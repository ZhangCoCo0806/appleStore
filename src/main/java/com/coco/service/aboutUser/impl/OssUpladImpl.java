package com.coco.service.aboutUser.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.coco.service.aboutUser.OssUpLoad;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;
@Service
public class OssUpladImpl implements OssUpLoad {
    @Override
    public String upload(MultipartFile multipartFile, String bucketStr,String filePathStr) {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5tKJuYsxT3tsd2qcJoki";
        String accessKeySecret = "R7ruaAXTktZcJTvnQkgBMHFyVH3129";
        String bucketName = bucketStr;
        OSS ossClient = null;
        try{
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = multipartFile.getInputStream();
            //设置响应头,如果不设置点击链接后直接就是下载该文件
            ObjectMetadata objectMetadata=new ObjectMetadata();
            objectMetadata.setContentType("image/jpg");
            String filePath=filePathStr;
            String originName=multipartFile.getOriginalFilename();
            String fileName= UUID.randomUUID().toString();
            String suffix=originName.substring(originName.lastIndexOf("."));
            String newName=fileName+suffix;
            String fileUrl= filePath+"/"+newName;
            ossClient.putObject(bucketName, fileUrl, inputStream,objectMetadata);
            return "https://"+bucketName+"."+endpoint+"/"+fileUrl;
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }finally {
            ossClient.shutdown();
        }
    }

    @Override
    public String delete(String bucketStr,String filePath) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tKJuYsxT3tsd2qcJoki";
        String accessKeySecret = "R7ruaAXTktZcJTvnQkgBMHFyVH3129";
        // 填写Bucket名称。
        String bucketName = bucketStr;
        // 填写文件完整路径。文件完整路径中不能包含Bucket名称。
//        String objectName = "image_test01/ba4a54af-22b0-4d2e-885a-d5e1d0870af1.jpeg";
        String objectName = filePath;
        /*System.out.println(filePath);*/
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(bucketName, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "true";
    }
}
