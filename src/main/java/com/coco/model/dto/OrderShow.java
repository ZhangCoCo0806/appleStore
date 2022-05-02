package com.coco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderShow {
    private String goodsName;
    private String imgUrl;
    private double goodsPrice;
    private java.sql.Date goodsDate;
    private String orderNum;
    private java.sql.Date buyTime;
    private String account;
    private String phone;
}
