package com.coco.service.aboutGoods;

import com.coco.model.dto.*;
import com.coco.model.pojo.Goods;
import com.coco.model.pojo.GoodsComments;
import com.coco.model.pojo.GoodsImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    /**
     * 获取所有商品以及每个商品的图片和每个商品是那个用户发布的
     * @return 所有商品信息
     */
    List<GoodsUserImage> getAllGoods(int typeId,String goodsName);

    /**
     * 获取用户发布的所有商品
     * @param uid 用户id
     * @return 用户发布的所有商品
     */
    List<GoodsAndImage> getAllGoodsByUser(@Param("uid") int uid);

    /**
     * 获取用户发布的所有商品
     * @param uid 用户id
     * @return 用户发布的所有商品
     */
    List<GoodsAndImage> showAllUserGoods(@Param("uid") int uid);

    /**
     * 根据商品id获取商品的所有用户评论
     * @param gid 商品id
     * @return 商品的评论
     */
    List<GoodsText> getAllGoodsTextByUid(@Param("gid") int gid);

    /**
     * 根据商品id获取对应的商品相关信息--》商品详情页面
     * @param goodsId 商品id
     * @return 对应的商品
     */
    GoodsUserImage getGoodsByGid(@Param("gid") int goodsId);

    /**
     * 获取商品的id和商品的图片
     * 轮播图功能
     * @return
     */
    List<GoodsANDImageForSlider> getAllGoodsANDImageForSlider();

    /**
     * 发布商品
     * @param goods 要发布的商品实体类
     * @return 是否发布成功
     */
    int insertGoods(Goods goods);

    /**
     * 发布商品:商品图片上传
     * @param goodsImage 商品图片对象
     * @return 受影响记录数
     */
    int insertGoodsImage(GoodsImage goodsImage);

    /**
     * 获取商品评论和用户信息，用于首页展示
     * @return 商品评论
     */
    List<GoodsCommentForIndex> goodsComments();

    /**
     * 用户评论添加
     * @param goods 商品评论实体类
     * @return 受影响记录数
     */
    int addComments(GoodsComments goods);
}
