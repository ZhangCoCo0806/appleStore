package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsComments {
    private Integer id;
    private Integer userId;
    private Integer GoodsId;
    private String goodsText;
}
