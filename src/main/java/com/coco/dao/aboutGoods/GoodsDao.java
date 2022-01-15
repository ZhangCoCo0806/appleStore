package com.coco.dao.aboutGoods;

import com.coco.model.dto.GoodsANDImageForSlider;
import com.coco.model.dto.GoodsUserImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 获取所有商品以及每个商品的图片和每个商品是那个用户发布的
     * @return 所有商品信息
     */
    List<GoodsUserImage> getAllGoods(@Param("typeId") int typeId);

    /**
     * 获取商品的id和商品的图片
     * 轮播图功能
     * @return GoodsANDImageForSlider实体类
     */
    List<GoodsANDImageForSlider> getAllGoodsANDImageForSlider();
}
