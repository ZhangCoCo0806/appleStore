package com.coco.service.aboutGoods.impl;

import com.coco.dao.aboutGoods.GoodsCartDao;
import com.coco.model.dto.GoodsCartShow02;
import com.coco.model.dto.GoodsCatShow01;
import com.coco.model.dto.OrderShow;
import com.coco.service.aboutGoods.GoodsCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsCartServiceImpl implements GoodsCartService {
    @Resource
    private GoodsCartDao goodsCartDao;

    @Override
    public int addCart(int goodsId, int userId) {
        return goodsCartDao.addCart(goodsId, userId);
    }

    @Override
    public List<GoodsCatShow01> showCart(int uid) {
        return goodsCartDao.showCart(uid);
    }

    @Override
    public List<GoodsCartShow02> showCart02(int uid, String goodsName) {
        return goodsCartDao.showCart02(uid, goodsName);
    }


    @Override
    public int deleteGoodsInCart(int cid) {
        return goodsCartDao.deleteGoodsInCart(cid);
    }

    @Override
    public int buyGoods(int goodsId, int userId) {
        return goodsCartDao.buyGoods(goodsId, userId);
    }

    @Override
    public int changeNum(int cartId) {
        return goodsCartDao.changeNum(cartId);
    }

    @Override
    public List<OrderShow> orderShow(int uid) {
        return goodsCartDao.orderShow(uid);
    }
}
