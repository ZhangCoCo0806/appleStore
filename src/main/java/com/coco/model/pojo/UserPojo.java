package com.coco.model.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class UserPojo {
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户账户")
    private String userAccount;
    @ApiModelProperty("用户密码")
    private String userPass;
    @ApiModelProperty("用户手机号")
    private String phone;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户注册时间")
    private java.sql.Timestamp joinData;
}
