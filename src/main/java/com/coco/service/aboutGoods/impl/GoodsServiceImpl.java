package com.coco.service.aboutGoods.impl;

import com.coco.dao.aboutGoods.GoodsDao;
import com.coco.model.dto.GoodsANDImageForSlider;
import com.coco.model.dto.GoodsUserImage;
import com.coco.model.pojo.Goods;
import com.coco.model.pojo.GoodsImage;
import com.coco.service.aboutGoods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;
    @Override
    public List<GoodsUserImage> getAllGoods(int typeId) {
        return goodsDao.getAllGoods(typeId);
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
}
