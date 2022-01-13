package com.coco.dao.aboutGoods;

import com.coco.model.dto.GoodsUserImage;
import com.coco.model.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTypeDao {
    /**
     * 获取所有的商品类别
     * 首页显示
     * @return 所有的商品类别
     */
    List<GoodsType> getAllGoodsType();
}
