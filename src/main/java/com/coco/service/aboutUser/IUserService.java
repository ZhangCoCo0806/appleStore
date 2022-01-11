package com.coco.service.aboutUser;

import com.coco.model.dto.User;
import com.coco.model.pojo.UserPojo;
import com.coco.model.pojo.UserRolePojo;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    /**
     * 用户的验证功能,shiro
     * 根据用户的账号查询该用户的信息
     * @param userAccount 用户账号
     * @return 对应的用户实体
     */
    User getUserByUserAccount(String userAccount);

    /**
     * 用户注册功能
     * @param user 用户实体
     * @return 受影响行数
     */
    int insertUser(UserPojo user);

    /**
     * 新注册用户默认设置普通用户角色和vip1角色
     * @param userRolePojo 用户角色表实体类
     * @return 受影响行数
     */
    int insertUserRole(UserRolePojo userRolePojo);

    /**
     * 根据用户的用户名获取到用户的id
     * @param userAccount 用户名
     * @return 用户id
     */
    int getUserIdByUserAccount(String userAccount);

    /**
     * 根据用户id获取到该用户的头像url
     * @param userId 用户id
     * @return 该用户的头像url
     */
    String getUserHeadImageUrl(int userId);

    /**
     * 根据用户的id修改头像url
     * @param userId 用户id
     * @return 受影响记录数
     */
    int updateUserHeadImage(int userId, String urlStr);

    /**
     * 用户注册时添加默认头像
     * @param userId 注册的用户id
     * @return 受影响记录数
     */
    int insertUserHeadImage(int userId);
}