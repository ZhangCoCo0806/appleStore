package com.coco;

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

@SpringBootTest
class AppleDealApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    private EmailTools emailTools;
    @Autowired
    private ItestDao itestDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private GoodsService goodsServicel;

    @Autowired
    private GoodsDao goodsDao;
    @Test
    void contextLoads() {
        /*itestDao.getAll().forEach(System.out::println);
        System.out.println(goodsTypeDao.getAllGoodsType());
        System.out.println(userService.getUserByUserAccount("zhangsan"));
        int i = userService.insertUser(new UserPojo(0, "ooooo", "asjdlkas", "646464", "111@qq.com"));
        userService.insertUserRole(new UserRolePojo(0,i,3));
        userService.insertUserRole(new UserRolePojo(0,i,4));
        System.out.println(userService.getUserHeadImageUrl(userService.getUserIdByUserAccount("lixi")));
        System.out.println(userService.updateUserHeadImage(userService.getUserIdByUserAccount("lixi"), "asdzxzcxzczxc"));

           String objectName = "image_test01/ba4a54af-22b0-4d2e-885a-d5e1d0870af1.jpeg";
        http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png
        http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/fc227efe-e6c0-410e-97b8-6b9dbf89b81d.jpg
        String oldUrl="http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png";
        String newUrl=oldUrl.substring(57);
        System.out.println(newUrl);
        System.out.println(userDao.getUserInfosByUserId(userDao.getUserIdByUserAccount("zhangshiqi")));
        System.out.println(userDao.updateUserInfosByUserId(new UserInfos(null, DateUtil.util2sql(DateUtil.str2util("1997-08-08")),10,"男","踢足球","阿萨德很骄傲开始",22)));
        System.out.println(userDao.insertUserInfos(24));
        System.out.println(userService.getUserDataByUserAccount("zhangshiqi"));
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("asjdjaskldjk");
        simpleMailMessage.setText("asjdklasjdkl");
        simpleMailMessage.setTo("2231925844@qq.com");
        simpleMailMessage.setFrom("3030223488@qq.com");
        mailSender.send(simpleMailMessage);
        System.out.println("asjdl");
        System.out.println(emailTools.sendEmailCode("验证码", "1500", "2231925844@qq.com", "2231925844@qq.com"));
        Random random=new Random();
        System.out.println(random.nextInt(4));
        System.out.println((int)((Math.random()*9+1)*100000));
        PageHelper.startPage(1,4);
        List<GoodsUserImage> allGoods = goodsService.getAllGoods();
        PageInfo<GoodsUserImage> pageInfo=new PageInfo<>(allGoods);
        goodsServicel.getAllGoods().forEach(System.out::println);*/
        /*PageHelper.startPage(1,4);
        List<GoodsUserImage> allGoods = goodsServicel.getAllGoods();
        PageInfo<GoodsUserImage> pageInfo=new PageInfo<>(allGoods);
        pageInfo.getList().forEach(System.out::println);*/
       /* goodsDao.getAllGoodsANDImageForSlider().forEach(System.out::println);*/
        /*String str = "2019-08-06";
        System.out.println(str);
        Goods aaa = new Goods(null, "aaa", 123.0, "", null, 4, 1, 1);
        System.out.println(goodsDao.insertGoods(aaa));
        System.out.println(aaa);*/
        /*System.out.println(goodsServicel.getGoodsByGid(1));*/
//        goodsServicel.getAllGoodsByUser(1).forEach(goodsUserImage -> System.out.println(goodsUserImage));
        /*goodsServicel.getAllGoodsTextByUid(1).forEach(goodsText -> System.out.println(goodsText));*/
        goodsServicel.getAllGoodsByUser(1).forEach(goodsUserImage -> System.out.println(goodsUserImage));
    }

}
