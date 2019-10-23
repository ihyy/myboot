package com.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)     //  表示是方法注解
@Retention(RetentionPolicy.RUNTIME)   //  可以加入到内存中 ， 可以用反射获得
public @interface Login {

    boolean check() default false;
}
