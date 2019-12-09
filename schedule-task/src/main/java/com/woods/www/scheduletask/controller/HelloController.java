package com.woods.www.scheduletask.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: woods
 * @date: 2019/12/7
 * @description:
 */
@RestController
@RequestMapping(value = "/hello")
@Slf4j
public class HelloController {

    @GetMapping(value = "/")
    public String hello(){

      log.info("{}", new Date());
        return new Date().toString();
    }
}
