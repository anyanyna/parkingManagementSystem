package com.gemcoder.system.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.gemcoder.system.config.MinIOConfig;

import io.minio.MinioClient;

/**
 * MinIO 上传测试（需先在环境变量中配置 MINIO_ENDPOINT / MINIO_ACCESS_KEY / MINIO_SECRET_KEY，
 * 并准备本地测试图片路径）
 */
public class MinioUtilTest {
	@Test
	public void testQeury() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, IOException {
		String endpoint = System.getenv().getOrDefault("MINIO_ENDPOINT", "http://127.0.0.1:9000");
		String accessKey = System.getenv().getOrDefault("MINIO_ACCESS_KEY", "YOUR_MINIO_ACCESS_KEY");
		String secretKey = System.getenv().getOrDefault("MINIO_SECRET_KEY", "YOUR_MINIO_SECRET_KEY");
		String localFile = System.getenv().getOrDefault("MINIO_TEST_FILE", "test.jpg");

		MinioUtil minioUtil = new MinioUtil();
		MinioClient mc = MinioClient.builder().endpoint(endpoint)
				.credentials(accessKey, secretKey).build();
		Field fd = MinioUtil.class.getDeclaredField("minioClient");
		fd.setAccessible(true);
		fd.set(minioUtil, mc);
		FileInputStream f = new FileInputStream(new File(localFile));
		byte[] bt = new byte[1024 * 1024];
		int len = f.read(bt);
		f.close();
		byte[] btes = new byte[len];
		System.arraycopy(bt, 0, btes, 0, len);
		minioUtil.uploadJPEG(btes, "test.jpg", MinIOConfig.pitureBucket);
	}
}
