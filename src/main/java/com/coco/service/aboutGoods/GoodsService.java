package com.coco.service.aboutGoods;

import com.coco.model.dto.GoodsUserImage;

import java.util.List;

public interface GoodsService {
    /**
     * 获取所有商品以及每个商品的图片和每个商品是那个用户发布的
     * @return 所有商品信息
     */
    List<GoodsUserImage> getAllGoods();
}
