package com.coco.model.dto;

import com.coco.model.pojo.GoodsImage;
import com.coco.model.pojo.UserPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsUserImage {
    private Integer id;
    private String goodsName;
    private Double goodsPrice;
    private String goodsText;
    private java.sql.Date goodsDate;
    private Integer goodsStart;
    private Integer goodsTypeId;
    private Integer goodsByUserId;
    private UserHandImg userHandImg;
    private List<GoodsImage> goodsImages;
}
