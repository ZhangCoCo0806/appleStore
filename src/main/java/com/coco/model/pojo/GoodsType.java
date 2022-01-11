package com.coco.model.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("商品类别实体类")
public class GoodsType {
    @ApiModelProperty("商品类别id")
    private Integer id;
    @ApiModelProperty("商品类别名称")
    private String typename;
}
