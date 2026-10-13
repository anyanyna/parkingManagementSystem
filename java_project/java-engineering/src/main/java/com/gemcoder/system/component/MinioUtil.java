package com.gemcoder.system.component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.gemcoder.system.config.MinIOConfig;
import com.gemcoder.system.ws.CapMatchServcie;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.RemoveBucketArgs;
import io.minio.RemoveObjectArgs;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import io.minio.http.Method;

@Component
public class MinioUtil {
	private static final Logger log = LoggerFactory.getLogger(MinioUtil.class);
	// @Value("${minio.bucket.name:demo}")
	// String miniobucketName;
	@Autowired
	private MinioClient minioClient;
	// @Autowired
	// private MinIOConfig configuration;

	/**
	 * 判断bucket是否存在，不存在则创建
	 */
	public boolean existBucket(String bucketName) {
		boolean exists;
		try {
			exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
			if (!exists) {
				minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
				exists = true;
			}
		} catch (Exception e) {
			log.warn(e.toString(), e);
			exists = false;
		}
		return exists;
	}

	/**
	 * 删除bucket
	 */
	public Boolean removeBucket(String bucketName) {
		try {
			minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
		} catch (Exception e) {
			log.warn(e.toString(), e);
			return false;
		}
		return true;
	}

	/**
	 * 上传文件
	 */
	public void uploadMultipartFile(MultipartFile file, String fileName, String bucketname) {
		// 使用putObject上传一个文件到存储桶中。
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
			uploadfile(inputStream, file.getSize(), file.getContentType(), fileName, bucketname);
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
	}

	public void uploadJPEG(byte[] bytes, String fileName, String bucketname) {
		ByteArrayInputStream bar = new ByteArrayInputStream(bytes);
		uploadfile(bar, bytes.length, "application/json", fileName, bucketname);
	}

	public void uploadLog(byte[] bytes, String fileName, String bucketname) {
		ByteArrayInputStream bar = new ByteArrayInputStream(bytes);
		uploadfile(bar, bytes.length, "application/json", fileName, bucketname);
	}

	private void uploadfile(InputStream inputStream, long filesize, String fileType, String fileName,
			String bucketname) {
		try {
			//.contentType(fileType)
			//minioClient.uploadObject(args)
			ObjectWriteResponse response=minioClient.putObject(PutObjectArgs.builder().bucket(bucketname).object(fileName)
					.stream(inputStream, filesize, -1).build());
			inputStream.close();
			//response.
			if(MinIOConfig.logBucket.equals(bucketname)) {
				log.info("response:{}",response.toString());
			}
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
	}



	/**
	 * 获取文件访问地址（有过期时间）
	 */
	public String getExpireFileUrl(String fileName, int time, TimeUnit timeUnit, String bucketname) {
		try {
			return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET)
					.bucket(bucketname).object(fileName).expiry(time, timeUnit).build());
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
		return null;
	}

	/**
	 * 获取文件访问地址
	 */
	public String getFileUrl(String fileName, String bucketname) {
		try {
			return minioClient.getPresignedObjectUrl(
					GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucketname).object(fileName).build());
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
		return null;
	}

	/**
	 * 下载文件
	 */
	public void download(HttpServletResponse response, String fileName, String bucketname) {
		InputStream in = null;
		try {
			// 获取对象信息
			StatObjectResponse stat = minioClient
					.statObject(StatObjectArgs.builder().bucket(bucketname).object(fileName).build());
			response.setContentType(stat.contentType());
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			// 文件下载
			in = minioClient.getObject(GetObjectArgs.builder().bucket(bucketname).object(fileName).build());
			IOUtils.copy(in, response.getOutputStream());
		} catch (Exception e) {
			log.warn(e.toString(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.warn(e.toString(), e);
				}
			}
		}
	}

	/**
	 * 删除文件
	 */
	public void delete(String fileName, String bucketname) {
		try {
			minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketname).object(fileName).build());
		} catch (Exception e) {
			log.warn(e.toString(), e);
		}
	}
}
