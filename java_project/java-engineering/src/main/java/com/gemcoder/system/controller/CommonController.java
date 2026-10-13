package com.gemcoder.system.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppusermanagementService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Value("${upload.dir:d:\\upload}")
    String uploadDir;


    @PostMapping(value = "/uploadFile")
    @ResponseBody
    public Result uploadFile(final @RequestParam("file") MultipartFile file)
            throws IllegalStateException, IOException {
        //补充代码，上传到指定的路径下
        String originalFilename = file.getOriginalFilename();
        String fileName = IdUtil.simpleUUID() + "." + FileNameUtil.getSuffix(originalFilename);
        String filePath;
        if (uploadDir.endsWith(File.separator)) {
            filePath = uploadDir + "commonUpload" + File.separatorChar + fileName;
        } else {
            filePath = uploadDir + File.separatorChar + "commonUpload" + File.separatorChar + fileName;
        }
        FileUtil.writeFromStream(file.getInputStream(), filePath);
        return new Result(true, "上传成功", fileName);
    }

    @GetMapping(value = "/vewFile")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> vewFile(String fileName, HttpServletRequest request)
            throws IOException {
        if (StrUtil.isBlank(fileName)){
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).eTag("文件名为空！").build();
        }
        String filePath;
        if (uploadDir.endsWith(File.separator)) {
            filePath = uploadDir + "commonUpload" + File.separatorChar + fileName;
        } else {
            filePath = uploadDir + File.separatorChar + "commonUpload" + File.separatorChar + fileName;
        }
        return responseResource(filePath, request);
    }

    public static ResponseEntity<ByteArrayResource> responseResource(String filePath, HttpServletRequest request) throws UnsupportedEncodingException {
        if (isIllegalFilePath(filePath)) {
            ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).eTag("Invalid filePath").build();
        }
        if (FileUtil.exist(filePath)) {
            String filename = URLEncoder.encode(FileNameUtil.getName(filePath), "UTF-8");
            byte[] fileBytes = FileUtil.readBytes(filePath);
            String fileCode = DigestUtil.md5Hex16(fileBytes);
            String cacheCode = request.getHeader("If-None-Match");
            if (StrUtil.isNotEmpty(cacheCode) && StrUtil.contains(cacheCode, fileCode)) {
                return ResponseEntity.status(304).header("Content-disposition", "inline;filename=" + filename).build();
            } else {
                String contentType = MediaTypeFactory.getMediaType(filePath).orElse(MediaType.APPLICATION_OCTET_STREAM).toString();
                return ResponseEntity.ok()
                        .header("Content-Type", contentType)
                        .header("Cache-Control", "no_cache")
                        .header("Etag", fileCode)
                        .header("Content-disposition", "inline;filename=" + filename)
                        .header("If-None-Match", fileCode)
                        .body(new ByteArrayResource(fileBytes));
            }
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    /**
     * 判断文件地址是否非法
     * 文件路径中出现  ../  为非法文件地址
     *
     * @param filePath
     * @return true：非法
     */
    public static boolean isIllegalFilePath(String filePath) {
        Pattern pattern = Pattern.compile("\\.\\./", Pattern.DOTALL);
        return pattern.matcher(filePath).find();
    }
}
