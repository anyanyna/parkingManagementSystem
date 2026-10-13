package com.gemcoder.system.util;

import cn.hutool.extra.spring.SpringUtil;
import com.gemcoder.system.config.BaseWebMvcConfig;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author system
 */
@SuppressWarnings("unused")
public class PathUtil {
    /**
     * 读取resource目录下的文件
     *
     * @param filePath
     * @return
     */
    public static String readResourceFile(String filePath) {
        try {
            ClassPathResource resource = new ClassPathResource(filePath);
            try (InputStream inputStream = resource.getInputStream()) {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    result.write(buffer, 0, length);
                }
                return result.toString(StandardCharsets.UTF_8.name());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取项目资源存放目录sdk
     *
     * @return 存放资源目录路径
     */
    public static String sdkOfGetRootPath() {
        BaseWebMvcConfig baseWebMvcConfig = SpringUtil.getBean(BaseWebMvcConfig.class);
        String resource = baseWebMvcConfig.getResourcePathString();
        File directory = new File(resource + File.separator + "upload");
        // 检查目录是否存在
        if (!directory.exists()) {
            // 目录不存在，尝试创建
            directory.mkdirs();
        }
        return resource;
    }

}
