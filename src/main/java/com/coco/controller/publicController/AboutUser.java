package com.coco.controller.publicController;

import com.coco.model.dto.UserData;
import com.coco.model.pojo.UserAddress;
import com.coco.model.pojo.UserInfos;
import com.coco.model.pojo.UserPojo;
import com.coco.model.pojo.UserRolePojo;
import com.coco.service.aboutUser.IUserService;
import com.coco.service.aboutUser.OssUpLoad;
import com.coco.service.sendEmail.EmailTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api("和用户有关的控制类")
@Controller
public class AboutUser {
    @Resource
    private IUserService userService;
    @Resource
    private OssUpLoad ossUpLoad;
    @Resource
    private EmailTools emailTools;

    /**
     * 跳转到用户登录界面
     *
     * @return 用户登录视图
     */
    @ApiOperation("/跳转到用户登录界面接口")
    @GetMapping("/toLogin")
    public String toLogin(HttpSession session) {
        if (session.getAttribute("userLoginName") != null) {
            return "redirect:/index";
        }
        return "aboutUser/login";
    }

    @GetMapping("/testSession")
    @ResponseBody
    public String testSession(HttpSession session){
        Object userLoginName = session.getAttribute("userLoginName");
        System.out.println(userLoginName);
        return (String) userLoginName;
    }

    /**
     * 用户登录验证接口
     *
     * @param name  用户名
     * @param pass  用户密码
     * @param model model
     * @return 根据验证情况返回对应的界面
     */
    @ApiOperation("用户登录验证接口")
    @PostMapping("/login")
    public String login(@ApiParam("用户名") String name, @ApiParam("用户密码") String pass, @ApiParam("model") Model model, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, pass);
        try {
            subject.login(token);//执行登录的方法,如果没有异常就可以登录
            session.setAttribute("userLoginName", name);
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名有误");
            return "aboutUser/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码有误");
            return "aboutUser/login";
        }
    }

    /**
     * 用户注册接口
     *
     * @param user 用户输入的注册信息
     * @return 是否注册成功
     */
    @ApiOperation("用户注册接口")
    @PostMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(@ApiParam("用户输入的注册信息") @RequestBody UserPojo user) {
        try {
            int num = userService.insertUser(user);
            userService.insertUserRole(new UserRolePojo(0, num, 3));
            userService.insertUserRole(new UserRolePojo(0, num, 4));
            userService.insertUserHeadImage(num);
            userService.insertUserInfos(num);
        } catch (Exception e) {
            return "no";
        }
        return "ok";
    }

    /**
     * 用户修改头像功能
     *
     * @param file MultipartFile对象
     * @return 用户头像地址url
     */
    @ApiOperation("用户头像修改接口")
    @PutMapping("/userImgUpload")
    @ResponseBody
    public String userImgUpload(@ApiParam("MultipartFile对象") MultipartFile file, HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        String urlStr = "";
        try {
            String oldImageUrl = userService.getUserHeadImageUrl(userService.getUserIdByUserAccount(userName));
            if ("http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png".equals(oldImageUrl)) {
                //   如果是默认头像的url,则直接修改
                urlStr = ossUpLoad.upload(file, "apple-shop-all-images", "userHeaderImages");
                userService.updateUserHeadImage(userService.getUserIdByUserAccount(userName), urlStr);
            } else {
                //如果不是默认头像的url,则先将阿里云oss中的用户之前的头像删除,然后再讲用户的新头像上传
                ossUpLoad.delete("apple-shop-all-images", oldImageUrl.substring(58));
//                https://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/ed0858d6-4ff2-4e56-a659-694d87441438.png
                //userHeaderImages/ed0858d6-4ff2-4e56-a659-694d87441438.png
                urlStr = ossUpLoad.upload(file, "apple-shop-all-images", "userHeaderImages");
                userService.updateUserHeadImage(userService.getUserIdByUserAccount(userName), urlStr);
            }
        } catch (Exception e) {
            return "no";
        }
        return urlStr;
    }

    /**
     * 用户登录以后获取用户的头像url用于显示
     *
     * @param session session
     * @return 用户的url
     */
    @ApiOperation("用户登录以后获取用户的头像url用于显示-接口")
    @GetMapping("/getUserHeadImage")
    @ResponseBody
    public String getUserHeadImage(HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        return userService.getUserHeadImageUrl(userService.getUserIdByUserAccount(userName));
    }

    /**
     * 用户退出
     *
     * @param session session
     * @return 退出到首页
     */
    @ApiOperation("用户退出接口")
    @GetMapping("/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("userLoginName");
        return "redirect:/index";
    }

    /**
     * 获取用户个人资料用于显示
     *
     * @param session session
     * @return 用户的个人资料
     */
    @ApiOperation("获取用户的个人信息接口")
    @GetMapping("/getUserInfos")
    @ResponseBody
    public UserInfos getUserInfos(HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        UserInfos userInfosByUserId = userService.getUserInfosByUserId(userService.getUserIdByUserAccount(userName));
//        System.out.println(userInfosByUserId);
        return userInfosByUserId;
    }

    /**
     * 用户基础信息修改
     *
     * @param userInfos 用户基础信息
     * @return 修改成功后的新的信息
     */
    @ApiOperation("用户基础信息修改接口")
    @PutMapping("/updateUserInfos")
    @ResponseBody
    public UserInfos updateUserInfos(@ApiParam("用户提交的基础信息") @RequestBody UserInfos userInfos) {
        System.out.println(userInfos);
        if (userService.updateUserInfosByUserId(userInfos) > 0) {
            UserInfos userInfo = userService.getUserInfosByUserId(userInfos.getUserId());
            return userInfo;
        } else {
            return new UserInfos();
        }
    }

    /**
     * 根据账号获取用户基础信息
     *
     * @param session session
     * @return 用户基础信息
     */
    @ApiOperation("根据账号获取用户基础信息接口")
    @GetMapping("/getUserDataByUserId")
    @ResponseBody
    public UserData getUserDataByUserId(HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        return userService.getUserDataByUserAccount(userName);
    }

    /**
     * 用户新增地址
     *
     * @param userAddressInfo 用户地址信息
     * @param session         session
     * @return 是否新增成功
     */
    @ApiOperation("用户新增地址")
    @RequestMapping("/getUserAddress")
    @ResponseBody
    public String getUserAddress(@RequestBody UserAddress userAddressInfo, HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        try {
            userAddressInfo.setUserId(userService.getUserIdByUserAccount(userName));
            userService.insertUserAddress(userAddressInfo);
            return "ok";
        } catch (Exception e) {
            return "no";
        }
    }

    /**
     * 用户注册邮箱验证码接口
     *
     * @param userEmail 用户输入的邮箱
     * @return 验证码
     */
    @ApiOperation("用户注册邮箱验证码接口")
    @GetMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(@RequestParam("UserEmail") String userEmail) {
        System.out.println(userEmail);
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        emailTools.sendEmailCode("小可爱,欢迎你注册本网站,以下是邮箱验证码!", "宝儿,欢迎注册本网站,验证码是:" + code, userEmail, "2231925844@qq.com");
        return code;
    }//updatePass

    @PutMapping("getAccount")
    @ResponseBody
    public String getAccount(HttpSession session) {
        String userName = (String) session.getAttribute("userLoginName");
        System.out.println("哈哈哈哈" + "--------" + userName);
        return "ok";
    }

    @PutMapping("updatePass")
    @ResponseBody
    public String updatePass() {
        return "ok";
    }
}
