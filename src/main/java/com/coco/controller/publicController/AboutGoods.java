package com.coco.controller.publicController;

import com.coco.model.dto.GoodsUserImage;
import com.coco.service.aboutGoods.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
@RequestMapping("/goods")
public class AboutGoods {
    @Autowired
    private GoodsService goodsService;

    /**
     * 显示所有商品信息,是哪一个用户发布的,该用户的信息和头像接口
     * @return 商品信息+该商品用户信息+用户头像
     */
    @GetMapping("/getAllGoodsAndGoodsUserAndUserHeadUrl")
    @ResponseBody
    public PageInfo<GoodsUserImage> getAllGoodsAndGoodsUserAndUserHeadUrl(@RequestParam("pn") int pageNum){
        PageHelper.startPage(pageNum,8);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods();
        PageInfo<GoodsUserImage> pageInfo=new PageInfo<>(allGoods);
        return pageInfo;
    }
}
