package com.coco.service.aboutGoods;

import com.coco.model.dto.GoodsANDImageForSlider;
import com.coco.model.dto.GoodsUserImage;
import com.coco.model.pojo.Goods;
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
}
