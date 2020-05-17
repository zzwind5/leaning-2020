package com.jie.anno.com.jie.anno.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 17:50
 */
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("Cat constractor .....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat destroy .....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat init .....");
    }
}
