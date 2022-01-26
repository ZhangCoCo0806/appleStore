package com.coco.controller.publicController;

import com.coco.model.dto.GoodsANDImageForSlider;
import com.coco.model.dto.GoodsUserImage;
import com.coco.model.pojo.Goods;
import com.coco.model.pojo.GoodsImage;
import com.coco.service.aboutGoods.GoodsService;
import com.coco.service.aboutUser.IUserService;
import com.coco.service.aboutUser.OssUpLoad;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Api("商品相关控制器")
@Controller
@RequestMapping("/goods")
public class AboutGoods {
    @Resource
    private GoodsService goodsService;

    @Resource
    private IUserService userService;

    @Resource
    private OssUpLoad ossUpLoad;
    /**
     * 显示所有商品信息,是哪一个用户发布的,该用户的信息和头像接口
     * @return 商品信息+该商品用户信息+用户头像
     */
    @ApiOperation("首页显示商品+商品是哪个用户发布的+该用户的信息+用户头像接口")
    @GetMapping("/getAllGoodsAndGoodsUserAndUserHeadUrl")
    @ResponseBody
    public PageInfo<GoodsUserImage> getAllGoodsAndGoodsUserAndUserHeadUrl(@ApiParam("分页页码") @RequestParam("pn") int pageNum){
        PageHelper.startPage(pageNum,8);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods(0,null);
        PageInfo<GoodsUserImage> pageInfo=new PageInfo<>(allGoods);
        return pageInfo;
    }

    /**
     * 轮播图商品显示固定查询5个商品信息
     * @return 商品的信息以及商品的图片
     */
    @ApiOperation("轮播图商品显示固定查询5个商品信息")
    @GetMapping("/getSliderGoods")
    @ResponseBody
    public List<GoodsANDImageForSlider> getSliderGoods(){
        return goodsService.getAllGoodsANDImageForSlider();
    }

    /**
     * 根据商品类型id该类型下所有商品
     * @param typeId 类型id
     * @return 对应类型的所有商品
     */
    @ApiOperation("根据商品类型id该类型下所有商品")
    @GetMapping("/getGoodsByTypeId")
    @ResponseBody
    public List<GoodsUserImage> getGoodsByTypeId(@RequestParam("typeId") int typeId){
        System.out.println(typeId);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods(typeId,null);
        return allGoods;
    }

    /**
     * 根据商品名称进行模糊查询商品
     * @param goodsName 商品名称
     * @return 模糊匹配到的商品
     */
    @ApiOperation("根据商品名称进行模糊查询商品")
    @GetMapping("/getGoodsByGoodsName")
    @ResponseBody
    public List<GoodsUserImage> getGoodsByGoodsName(@RequestParam("goodsName") String goodsName){
        List<GoodsUserImage> goods=goodsService.getAllGoods(0,goodsName);
        return goods;
    }
    /**
     * 发布商品接口
     * @param file MultipartFile对象
     * @param goodsName 商品名称
     * @param goodsPrice 商品价格
     * @param goodsText 商品描述
     * @param goodsStar 商品星级
     * @param goodsType 商品类别
     * @return 是否添加成功
     */
    @ApiOperation("发布商品接口")
    @PostMapping("/pushGoods")
    @ResponseBody
    public String insertGoods(MultipartFile[] file,
                              @RequestParam("goodsName") String goodsName,
                              @RequestParam("goodsPrice") double goodsPrice,
                              @RequestParam("goodsText") String goodsText,
                              @RequestParam("goodsStar") int goodsStar,
                              @RequestParam("goodsType") int goodsType,
                              HttpSession session) {
        try {
            String userName = (String) session.getAttribute("userLoginName");
            int userId = userService.getUserIdByUserAccount(userName);
            Goods goods = new Goods(null, goodsName, goodsPrice, goodsText, null, goodsStar, goodsType, userId);
            goodsService.insertGoods(goods);
            for (int i = 0; i < file.length; i++) {
                String goodsUrl = ossUpLoad.upload(file[i], "apple-shop-all-images", "goodsImages");
                goodsService.insertGoodsImage(new GoodsImage(null,goodsUrl,goods.getId()));
            }
            return "ok";
        }catch (Exception e){
            return "no";
        }
    }

    /**
     * 商品详情接口
     * @param goodsId 商品的id
     * @param model model
     * @return 商品详情页面
     */
    @ApiOperation("商品详情接口")
    @RequestMapping("/getGoodsById")
    public String getGoodsById(@RequestParam("gid") Integer goodsId, Model model){
        model.addAttribute("goodsInfosById",goodsService.getGoodsByGid(goodsId));
        return "aboutGoods/goodsInfoPage";
    }
}
