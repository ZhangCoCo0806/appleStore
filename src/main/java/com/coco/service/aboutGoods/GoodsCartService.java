package com.coco.service.aboutGoods;

import com.coco.model.dto.GoodsCartShow02;
import com.coco.model.dto.GoodsCatShow01;
import com.coco.model.dto.OrderShow;
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
    List<GoodsCartShow02> showCart02(int uid,String goodsName);

    /**
     * 根据购物车中商品的编号删除商品
     * @param cid 购物车中商品的编号
     * @return 受影响记录数
     */
    int deleteGoodsInCart(int cid);

    /**
     * 商品购买，下订单
     * @param goodsId 商品id
     * @param userId 买家id
     * @return 受影响记录数
     */
    int buyGoods(int goodsId,int userId);

    /**
     * 修改购物车中是否下单
     * @param cartId 购物车中的id
     * @return 受影响记录数
     */
    int changeNum(int cartId);

    /**
     * 订单查看
     * @param uid 用户编号
     * @return 订单信息
     */
    List<OrderShow> orderShow(int uid);
}
