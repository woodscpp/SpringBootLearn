package com.woods.www.scheduletask.quartz;

import lombok.Getter;
import lombok.Setter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Setter
@Getter
public class ParamJob extends QuartzJobBean {

    HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.sayHello();
    }
}
