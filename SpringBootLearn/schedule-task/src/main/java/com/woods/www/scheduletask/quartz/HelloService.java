package com.woods.www.scheduletask.quartz;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Slf4j
public class HelloService {
    public void sayHello(){
        log.info("param job>>>{}, Thread>>>{}", new Date(), Thread.currentThread().getId());
    }
}
