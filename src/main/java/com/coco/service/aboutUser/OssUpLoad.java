package com.coco.service.aboutUser;

import org.springframework.web.multipart.MultipartFile;

public interface OssUpLoad {
    String upload(MultipartFile multipartFile,String bucketStr,String filePathStr);
    String delete(String bucketStr,String filePath);
}
