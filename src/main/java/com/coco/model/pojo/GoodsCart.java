package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCart {
    private int id;
    private int goodsId;
    private int userId;
    private java.sql.Date addDate;
    private int isSuccess;
}
