package com.coco.service.sendEmail;

public interface EmailTools {
    /**
     * 发送验证码到邮箱
     * @param title 邮件标题
     * @param text 邮件内容
     * @param toPerson 发给谁?
     * @param fromPerson 从谁发出?
     * @return 师傅偶发送成功
     */
    String sendEmailCode(String title,String text,String toPerson,String fromPerson);
}
