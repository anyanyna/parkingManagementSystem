package com.gemcoder.system.service.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

@Component
@EnableScheduling
public class ScheduledTask {

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void updateVehicleBlockListStatus(){
        executeSQL("update vehicle_block_list set `status`='已失效' WHERE end_time<=NOW()");
    }
}
