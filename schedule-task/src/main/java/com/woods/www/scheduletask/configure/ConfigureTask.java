package com.woods.www.scheduletask.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Component
@Configuration
@EnableScheduling
@EnableAsync
@Slf4j
public class ConfigureTask {

    @Async
    // cron 格式 秒 分 时 日 月 年
    // 每5秒 执行一次
    @Scheduled(cron="0/5 * * * * *")
    public void configureTask1(){
        log.info("NO-1-{},Thread>{}", new Date(), Thread.currentThread().getId());
    }

    @Async
    // 每4秒 执行一次
    @Scheduled(cron="0/4 * * * * *")
    public void configureTask2(){
        log.info("NO-2-{},Thread>{}", new Date(), Thread.currentThread().getId());
    }

    // 每3秒开始执行一次
    @Scheduled(fixedRate = 3000)
    public void configureTask3() throws Exception{
        log.info("NO-3-{},Thread>{}", new Date(), Thread.currentThread().getId());
    }

    // 上一个任务完成后3秒开始执行
    @Scheduled(fixedDelay = 3000)
    public void configureTask4() throws Exception{
        log.info("NO-3-{},Thread>{}", new Date(), Thread.currentThread().getId());
    }
}
