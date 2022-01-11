package com.coco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    /*select u.userAccount userAccount,u.phone userPhone,u.email userEmail,u.joinData userJoinData,ui.birth userBirth,ui.age userAge,uh.url userHeadImage
    from user u,userinfors ui,userheadimg uh
    where u.id=22
    and ui.userId=u.id
    and uh.userId=u.id*/
    private String userAccount;
    private String userPhone;
    private String userEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
    private java.sql.Timestamp userJoinData;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date userBirth;
    private Integer userAge;
    private String userHeadImage;
}
