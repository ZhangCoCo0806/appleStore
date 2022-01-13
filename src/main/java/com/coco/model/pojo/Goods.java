package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String goodsName;
    private Double goodsPrice;
    private String goodsText;
    private String goodsDate;
    private Integer goodsStart;
    private Integer goodsTypeId;
    private Integer goodsByUserId;
}
