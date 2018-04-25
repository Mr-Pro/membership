package cn.lger.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-15.
 */
public class FileUploadUtil {

    /**
     * 上传文件
     * @param multipartFile multipartFile
     * @param prefixPath 前缀路径
     * @param fileName 上传后的文件名
     * @return 上传后最终的相对路径+文件名
     * @throws Exception 有可能空指针异常和IO异常
     */
    public static String upload(MultipartFile multipartFile, String prefixPath, String fileName) throws Exception {
        //得出上传的绝对路径
        String uploadPath = Objects.requireNonNull(ClassUtils.getDefaultClassLoader().getResource("")).getPath() +"/static"+ prefixPath;
        File file = new File(uploadPath);
        if (!file.exists())
            if (file.mkdirs())
                System.out.println("成功创建目录");
        //获取上传的后缀名
        String suffixName = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        //新建最终确定的文件
        file = new File(uploadPath+fileName+suffixName);
        multipartFile.transferTo(file);
        return prefixPath+fileName+suffixName;
    }

}
