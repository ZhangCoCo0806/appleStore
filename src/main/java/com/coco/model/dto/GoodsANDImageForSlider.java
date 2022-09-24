package com.coco.model.dto;

import com.coco.model.pojo.GoodsImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsANDImageForSlider {
    private Integer id;
    private List<GoodsImage> goodsImages;
}
