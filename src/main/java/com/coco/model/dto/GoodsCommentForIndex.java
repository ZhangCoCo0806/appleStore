package com.coco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCommentForIndex {
    private String userAccount;
    private String url;
    private String goodsText;
}
