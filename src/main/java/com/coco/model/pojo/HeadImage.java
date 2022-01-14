package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadImage {
    private Integer id;
    private Integer userId;
    private String url;
}
