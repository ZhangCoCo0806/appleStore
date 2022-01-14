package com.coco.model.dto;

import com.coco.model.pojo.HeadImage;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHandImg {
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
    private java.sql.Date joinData;
    private HeadImage headImage;
}
