package com.woods.www.scheduletask.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Date;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Configuration
public class SimpleQuartzTask {

    // 定义工作项
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        // bean
        bean.setTargetBeanName("simpleJob");
        // 方法
        bean.setTargetMethod("sayHello");
        return bean;
    }


    // 定义任务触发器
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        // 开始时间
        bean.setStartTime(new Date());
        // 执行次数
        bean.setRepeatCount(3);
        // 每隔3秒执行一次
        bean.setRepeatInterval(3000);
        return bean;
    }

    // 启动任务
    @Bean
    SchedulerFactoryBean simpleSchedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(simpleTriggerFactoryBean().getObject());
        return bean;
    }
}
