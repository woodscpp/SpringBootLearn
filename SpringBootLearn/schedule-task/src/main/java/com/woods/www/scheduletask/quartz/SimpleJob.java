package com.woods.www.scheduletask.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@Component
@Slf4j
public class SimpleJob {
    public void sayHello(){
        log.info("simple job>>>{}, Thread>>>{}", new Date(), Thread.currentThread().getId());
    }
}
