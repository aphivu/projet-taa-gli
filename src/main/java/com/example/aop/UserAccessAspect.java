package com.example.aop;

import com.example.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;


@Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.example.service.*.*(..)) && args(usrn)")
    public void before(JoinPoint joinPoint, String usrn){

        logger.info("Check the user access for " + usrn);
        logger.info(" Allowed execution for {}", joinPoint);
    }
}
