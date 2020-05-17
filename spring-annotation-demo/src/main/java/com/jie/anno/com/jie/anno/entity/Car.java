package com.jie.anno.com.jie.anno.entity;

import lombok.Data;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 17:39
 */
@Data
public class Car {

    public Car() {
        System.out.println("Car constractor....");
    }

    public void init() {
        System.out.println("Car init.....");
    }

    public void destroy() {
        System.out.println("Car destroy.....");
    }
}
