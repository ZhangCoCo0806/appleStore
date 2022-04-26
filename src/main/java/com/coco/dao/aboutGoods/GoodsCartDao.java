package com.coco.dao.aboutGoods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsCartDao {
    /**
     * 商品添加购物车
     * @param goodsId 商品id
     * @param userId 用户id
     * @return 受影响记录数
     */
    int addCart(@Param("gid") int goodsId,@Param("uid") int userId);
}
