package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String goodsName;
    private Double goodsPrice;
    private String goodsText;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date goodsDate;
    private Integer goodsStart;
    private Integer goodsTypeId;
    private Integer goodsByUserId;
}
