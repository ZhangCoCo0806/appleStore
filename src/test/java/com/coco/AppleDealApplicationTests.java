package com.coco;

import com.coco.dao.aboutGoods.GoodsCartDao;
import com.coco.dao.aboutGoods.GoodsDao;
import com.coco.dao.aboutGoods.GoodsTypeDao;
import com.coco.dao.aboutUser.IUserDao;
import com.coco.dao.test.ItestDao;
import com.coco.service.aboutGoods.GoodsService;
import com.coco.service.aboutUser.IUserService;
import com.coco.service.sendEmail.EmailTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

@SpringBootTest
class AppleDealApplicationTests {
    @Resource
    private GoodsCartDao goodsCartDao;
    @Test
    void contextLoads() {
        System.out.println(goodsCartDao.showCart02(1, "ip"));
    }

}
