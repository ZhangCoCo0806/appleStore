package com.coco.service.aboutGoods.impl;

import com.coco.dao.aboutGoods.GoodsTypeDao;
import com.coco.model.pojo.GoodsType;
import com.coco.service.aboutGoods.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IGoodsTypeServiceImpl implements IGoodsTypeService {
    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<GoodsType> getAllGoodsType() {
        return goodsTypeDao.getAllGoodsType();
    }
}
