package com.coco.controller.publicController;

import com.coco.model.pojo.UserInfos;
import com.coco.model.pojo.UserPojo;
import com.coco.model.pojo.UserRolePojo;
import com.coco.service.aboutUser.OssUpLoad;
import com.coco.service.aboutUser.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Api("和用户有关的控制类")
@Controller
public class AboutUser {
    @Autowired
    private IUserService userService;
    @Autowired
    private OssUpLoad ossUpLoad;
    /**
     * 跳转到用户登录界面
     * @return 用户登录视图
     */
    @ApiOperation("/跳转到用户登录界面接口")
    @GetMapping("/toLogin")
    public String toLogin(HttpSession session){
        if (session.getAttribute("userLoginName")!=null){
            return "redirect:/index";
        }
        return "aboutUser/login";
    }

    /**
     * 用户登录验证接口
     * @param name 用户名
     * @param pass 用户密码
     * @param model model
     * @return 根据验证情况返回对应的界面
     */
    @ApiOperation("用户登录验证接口")
    @RequestMapping("/login")
    public String login(@ApiParam("用户名") String name, @ApiParam("用户密码") String pass, @ApiParam("model") Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, pass);
        try{
            subject.login(token);//执行登录的方法,如果没有异常就可以登录
            session.setAttribute("userLoginName",name);
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名有误");
            return "aboutUser/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码有误");
            return "aboutUser/login";
        }
    }

    /**
     * 用户注册接口
     * @param user 用户输入的注册信息
     * @return 是否注册成功
     */
    @ApiOperation("用户注册接口")
    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(@ApiParam("用户输入的注册信息") @RequestBody UserPojo user){
        try{
            int num = userService.insertUser(user);
            userService.insertUserRole(new UserRolePojo(0,num,3));
            userService.insertUserRole(new UserRolePojo(0,num,4));
            userService.insertUserHeadImage(num);
        }catch (Exception e){
            return "no";
        }
        return "ok";
    }

    /**
     * 用户修改头像功能
     * @param file MultipartFile对象
     * @return 用户头像地址url
     */
    @ApiOperation("用户头像修改接口")
    @PutMapping("/userImgUpload")
    @ResponseBody
    public String userImgUpload(@ApiParam("MultipartFile对象") MultipartFile file,HttpSession session){
        String userName=(String) session.getAttribute("userLoginName");
        String urlStr="";
        try{
            String oldImageUrl = userService.getUserHeadImageUrl(userService.getUserIdByUserAccount(userName));
            if ("http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png".equals(oldImageUrl)){
                //   如果是默认头像的url,则直接修改
                urlStr = ossUpLoad.upload(file, "apple-shop-all-images", "userHeaderImages");
                userService.updateUserHeadImage(userService.getUserIdByUserAccount(userName),urlStr);
            }else {
                //如果不是默认头像的url,则先将阿里云oss中的用户之前的头像删除,然后再讲用户的新头像上传
                ossUpLoad.delete("apple-shop-all-images",oldImageUrl.substring(58));
                urlStr = ossUpLoad.upload(file, "apple-shop-all-images", "userHeaderImages");
                userService.updateUserHeadImage(userService.getUserIdByUserAccount(userName),urlStr);
            }
        }catch (Exception e){
            return "no";
        }
        return urlStr;
    }

    /**
     * 用户登录以后获取用户的头像url用于显示
     * @param session session
     * @return 用户的url
     */
    @ApiOperation("用户登录以后获取用户的头像url用于显示")
    @GetMapping("/getUserHeadImage")
    @ResponseBody
    public String getUserHeadImage(HttpSession session){
        String userName=(String) session.getAttribute("userLoginName");
        return userService.getUserHeadImageUrl(userService.getUserIdByUserAccount(userName));
    }

    /**
     * 用户退出
     * @param session session
     * @return 退出到首页
     */
    @ApiOperation("用户退出")
    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("userLoginName");
        return "redirect:/index";
    }

    /**
     * 获取用户个人资料用于显示
     * @param session session
     * @return 用户的个人资料
     */
    @ApiOperation("获取用户的个人信息")
    @GetMapping("/getUserInfos")
    @ResponseBody
    public UserInfos getUserInfos(HttpSession session){
        String userName=(String) session.getAttribute("userLoginName");
        UserInfos userInfosByUserId = userService.getUserInfosByUserId(userService.getUserIdByUserAccount(userName));
//        System.out.println(userInfosByUserId);
        return userInfosByUserId;
    }

    /**
     * 用户基础信息修改
     * @param userInfos 用户基础信息
     * @return 修改成功后的新的信息
     */
    @PutMapping("/updateUserInfos")
    @ResponseBody
    public UserInfos updateUserInfos(@RequestBody UserInfos userInfos){
        if (userService.updateUserInfosByUserId(userInfos)>0){
            UserInfos userInfo = userService.getUserInfosByUserId(userInfos.getUserId());
            return userInfo;
        }else {
            return new UserInfos();
        }
    }
}
