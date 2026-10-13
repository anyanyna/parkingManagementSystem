package com.gemcoder.system.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableScheduling
public class DayStatisticJob {
	@Scheduled(cron = "0 0 0 * * ?")
    public void dayJob() {
		
	}
}
