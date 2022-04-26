package com.coco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCartShow02 {
    private int gid;
    private String goodsName;
    private String imgUrl;
    private double goodsPrice;
    private java.sql.Date goodsDate;
    private int goodsStart;
    private String userAccount;
    private String phone;
}
