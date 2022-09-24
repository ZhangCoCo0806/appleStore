package com.coco.service.aboutGoods.impl;

import com.coco.dao.aboutGoods.GoodsDao;
import com.coco.model.dto.*;
import com.coco.model.pojo.Goods;
import com.coco.model.pojo.GoodsComments;
import com.coco.model.pojo.GoodsImage;
import com.coco.service.aboutGoods.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<GoodsUserImage> getAllGoods(int typeId, String goodsName) {
        return goodsDao.getAllGoods(typeId, goodsName);
    }

    @Override
    public List<GoodsAndImage> getAllGoodsByUser(int uid) {
        return goodsDao.getAllGoodsByUser(uid);
    }

    @Override
    public List<GoodsAndImage> showAllUserGoods(int uid) {
        return goodsDao.showAllUserGoods(uid);
    }

    @Override
    public List<GoodsText> getAllGoodsTextByUid(int gid) {
        return goodsDao.getAllGoodsTextByUid(gid);
    }

    @Override
    public GoodsUserImage getGoodsByGid(int goodsId) {
        return goodsDao.getGoodsByGid(goodsId);
    }

    @Override
    public List<GoodsANDImageForSlider> getAllGoodsANDImageForSlider() {
        return goodsDao.getAllGoodsANDImageForSlider();
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public int insertGoodsImage(GoodsImage goodsImage) {
        return goodsDao.insertGoodsImage(goodsImage);
    }

    @Override
    public List<GoodsCommentForIndex> goodsComments() {
        return goodsDao.goodsComments();
    }

    @Override
    public int addComments(GoodsComments goods) {
        return goodsDao.addComments(goods);
    }
}
