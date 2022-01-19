package com.coco.controller.publicController;

import com.coco.model.pojo.GoodsType;
import com.coco.service.aboutGoods.IGoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@Api("用于商城首页展示相关的控制层")
@Controller//相当于<bean .... />
public class AboutIndex {
    @Resource
    private IGoodsTypeService goodsTypeService;

    @ApiOperation("跳转首页接口")
    @RequestMapping("/index")
    public String index(HttpSession session){
//        session.setAttribute("user","zhangsan");
        return "public/index";
    }

    /**
     * 导航栏商品类别显示
     * @return 得到所有的商品类别
     */
    @ApiOperation("首页导航栏展示商品类别接口")
    @GetMapping("/getAllGoodsType")
    @ResponseBody
    public List<GoodsType> getAllGoodsType(){
        List<GoodsType> allGoodsType = goodsTypeService.getAllGoodsType();
        return allGoodsType;
    }

    /**
     * 根据商品类别获得该类别下所有的商品
     * @param typeId 商品的类别
     * @return 该类别下的所有商品
     */
    @GetMapping("/getGoodsByTypeId")
    public String getGoodsByTypeId(@RequestParam("typeId") Integer typeId){
        System.out.println(typeId);
        return "aboutGoods/goodsByTypeId";
    }


}
