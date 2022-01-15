package com.coco.controller.publicController;

import com.coco.model.dto.GoodsANDImageForSlider;
import com.coco.model.dto.GoodsUserImage;
import com.coco.service.aboutGoods.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Api("商品相关控制器")
@Controller
@RequestMapping("/goods")
public class AboutGoods {
    @Autowired
    private GoodsService goodsService;

    /**
     * 显示所有商品信息,是哪一个用户发布的,该用户的信息和头像接口
     * @return 商品信息+该商品用户信息+用户头像
     */
    @ApiOperation("首页显示商品+商品是哪个用户发布的+该用户的信息+用户头像接口")
    @GetMapping("/getAllGoodsAndGoodsUserAndUserHeadUrl")
    @ResponseBody
    public PageInfo<GoodsUserImage> getAllGoodsAndGoodsUserAndUserHeadUrl(@ApiParam("分页页码") @RequestParam("pn") int pageNum){
        PageHelper.startPage(pageNum,8);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods(0);
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
     * 根据商品类型或去该类型下所有商品
     * @param typeId 类型id
     * @return 对应类型的所有商品
     */
    @GetMapping("/getGoodsByTypeId")
    @ResponseBody
    public List<GoodsUserImage> getGoodsByTypeId(@RequestParam("typeId") int typeId){
        System.out.println(typeId);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods(typeId);
        return allGoods;
    }
}
