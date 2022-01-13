package com.coco.service.aboutGoods.impl;

import com.coco.dao.aboutGoods.GoodsDao;
import com.coco.model.dto.GoodsUserImage;
import com.coco.service.aboutGoods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<GoodsUserImage> getAllGoods() {
        return goodsDao.getAllGoods();
    }
}
