package com.coco.service.aboutGoods;

import com.coco.model.dto.GoodsCartShow02;
import com.coco.model.dto.GoodsCatShow01;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCartService {
    /**
     * 商品添加购物车
     * @param goodsId 商品id
     * @param userId 用户id
     * @return 受影响记录数
     */
    int addCart(int goodsId,int userId);

    /**
     * 根据用户id显示购物车
     * @param uid 用户id
     * @return 购物车商品信息
     */
    List<GoodsCatShow01> showCart(int uid);

    /**
     * 显示购物车
     * @param uid 用户id
     * @return 购物车商品信息
     */
    List<GoodsCartShow02> showCart02(int uid);

    /**
     * 根据购物车中商品的编号删除商品
     * @param cid 购物车中商品的编号
     * @return 受影响记录数
     */
    int deleteGoodsInCart(int cid);
}
