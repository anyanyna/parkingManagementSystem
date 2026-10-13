package com.gemcoder.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;

@Configuration
public class MinIOConfig {
	// MinIO 连接信息请通过 application.yml 或环境变量注入，切勿将真实密钥写入代码
	@Value("${minio.host:127.0.0.1}")
	String minioHost;
	@Value("${minio.port:9000}")
	String minioPort;
	@Value("${minio.ak:}")
	String minioAK;
	@Value("${minio.sk:}")
	String minioSK;

	public static final String pitureBucket="licenseplatephoto";
	public static final String logBucket="log";
	@Bean
	public MinioClient minioClient() {
		return MinioClient.builder().endpoint("http://" + minioHost + ":" + minioPort).credentials(minioAK, minioSK)
				.build();
	}
}
