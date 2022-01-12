package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private Integer id;
    private String provice;
    private String city;
    private String county;
    private String detailedAddress;
    private Integer userId;
}
