package com.coco;

import com.coco.dao.aboutGoods.GoodsTypeDao;
import com.coco.dao.aboutUser.IUserDao;
import com.coco.dao.test.ItestDao;
import com.coco.model.pojo.UserPojo;
import com.coco.model.pojo.UserRolePojo;
import com.coco.service.aboutUser.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppleDealApplicationTests {

    @Autowired
    private ItestDao itestDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
//        itestDao.getAll().forEach(System.out::println);
//        System.out.println(goodsTypeDao.getAllGoodsType());
//        System.out.println(userService.getUserByUserAccount("zhangsan"));
        /*int i = userService.insertUser(new UserPojo(0, "ooooo", "asjdlkas", "646464", "111@qq.com"));
        userService.insertUserRole(new UserRolePojo(0,i,3));
        userService.insertUserRole(new UserRolePojo(0,i,4));*/
//        System.out.println(userService.getUserHeadImageUrl(userService.getUserIdByUserAccount("lixi")));
//        System.out.println(userService.updateUserHeadImage(userService.getUserIdByUserAccount("lixi"), "asdzxzcxzczxc"));

        /*   String objectName = "image_test01/ba4a54af-22b0-4d2e-885a-d5e1d0870af1.jpeg";
        http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png
        http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/fc227efe-e6c0-410e-97b8-6b9dbf89b81d.jpg*/
        String oldUrl="http://apple-shop-all-images.oss-cn-beijing.aliyuncs.com/userHeaderImages/morenImageHead.png";
        String newUrl=oldUrl.substring(57);
        System.out.println(newUrl);
    }

}
