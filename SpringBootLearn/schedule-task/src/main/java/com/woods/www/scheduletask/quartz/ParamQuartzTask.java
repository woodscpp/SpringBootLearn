package com.woods.www.scheduletask.quartz;

import org.quartz.DailyTimeIntervalTrigger;
import org.quartz.JobDataMap;
import org.quartz.impl.triggers.DailyTimeIntervalTriggerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Configuration
public class ParamQuartzTask {

    @Bean
    HelloService helloService(){
        return new HelloService();
    }

    // 定义任务
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(ParamJob.class);
        // 可以传递参数
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("helloService", helloService());
        bean.setJobDataMap(jobDataMap);
        return bean;
    }

    // 定义任务触发器
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("1 27 * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }

    // 任务触发器 类型多种多样
    DailyTimeIntervalTrigger dailyTimeIntervalTrigger(){
        DailyTimeIntervalTrigger timeIntervalTrigger = new DailyTimeIntervalTriggerImpl();
        return timeIntervalTrigger;
    }

    // 启动任务
    @Bean
    SchedulerFactoryBean paramSchedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerFactoryBean().getObject());
        return bean;
    }
}
