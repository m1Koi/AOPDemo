package com.m1ku.aopdemo.aspectj.checklogin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target(ElementType.METHOD)//注解使用在方法上
@Retention(RetentionPolicy.RUNTIME)//注解生效时间为运行时
public @interface CheckLogin {
}
