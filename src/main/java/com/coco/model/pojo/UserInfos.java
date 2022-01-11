package com.coco.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfos {
    private Integer id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private java.sql.Date birth;
    private Integer age;
    private String sex;
    private String hobbies;
    private String introduce;
    private Integer userId;
}
