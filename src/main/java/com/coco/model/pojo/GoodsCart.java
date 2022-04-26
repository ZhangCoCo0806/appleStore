package com.coco.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsCart {
    private int id;
    private int goodsId;
    private int userId;
    private java.sql.Date addDate;
}
