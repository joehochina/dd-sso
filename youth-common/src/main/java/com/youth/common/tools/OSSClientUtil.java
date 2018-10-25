package com.youth.common.tools;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 功能描述: 阿里云 OSS工具类
 *  @Author limaoda
 *  @Description //TODO
 *  @Date 17:10 2018/10/17
 **/
@Component
public class OSSClientUtil {

    private String endpoint = "https://oss-cn-beijing.aliyuncs.com";


    private String accessKeyId = "LTAIYhlvjCzNMkgS";

    private String accessKeySecret = "QQwajWNEOXoUwFNMY3iryfFgAv0SxV";

    private String bucketName = "xueyuan-images" ;

    private OSSClient ossClient;


    /**
     * 初始化
     */
    public void init() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }



    /**
     *
     * 功能描述: 上传网络流
     *
     *  @Author limaoda
     *  @Description //TODO
     *  @Date 17:17 2018/10/17
     *  @param 
     *  @return 
     **/
    public  String uploadFile(String fileName,InputStream  inputStream ){
        init();
        //默认null
        String url = null;
        try {
            // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
            ossClient.putObject(bucketName, fileName,inputStream);
            /***
             * 上传成功再返回的文件路径
             */
            url = endpoint.replaceFirst("https://","https://"+bucketName+".")+"/"+fileName;
        } catch ( OSSException oe) {
            oe.printStackTrace();
            return null;
        } catch ( ClientException ce) {
            ce.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return url;
    }



    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param filenameExtension
     *            文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

}
