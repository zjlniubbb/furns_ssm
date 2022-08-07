package com.zzz.furn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public class T1 {
    @Test
    public void testSqlSessionFactoryBean() {
        //1、创建 SpringIOC 容器
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ioc.getBean("pooledDataSource"));
        System.out.println(ioc.getBean("sqlSessionFactory"));
    }
}