package com.coco.dao.aboutGoods;

import com.coco.model.dto.GoodsCartShow02;
import com.coco.model.dto.GoodsCatShow01;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsCartDao {
    /**
     * 商品添加购物车
     * @param goodsId 商品id
     * @param userId 用户id
     * @return 受影响记录数
     */
    int addCart(@Param("gid") int goodsId,@Param("uid") int userId);

    /**
     * 根据用户id显示购物车
     * @param uid 用户id
     * @return 购物车商品信息
     */
    List<GoodsCatShow01> showCart(@Param("uid") int uid);

    /**
     * 显示购物车
     * @param uid 用户id
     * @return 购物车商品信息
     */
    List<GoodsCartShow02> showCart02(@Param("uid") int uid);

    /**
     * 根据购物车中商品的编号删除商品
     * @param cid 购物车中商品的编号
     * @return 受影响记录数
     */
    int deleteGoodsInCart(@Param("cid") int cid);
}
