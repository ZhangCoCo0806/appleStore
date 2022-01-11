package com.coco.service.aboutGoods;

import com.coco.model.pojo.GoodsType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IGoodsTypeService {
    /**
     * 获取所有的商品类别
     * 首页显示
     * @return 所有的商品类别
     */
    List<GoodsType> getAllGoodsType();
}
