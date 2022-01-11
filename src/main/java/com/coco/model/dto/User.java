package com.coco.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userAccount;
    private String userPass;
    private String phone;
    private String email;
    @ApiModelProperty("用户注册时间")
    private java.sql.Timestamp joinData;
    private List<RoleTable> roleTables;
}
