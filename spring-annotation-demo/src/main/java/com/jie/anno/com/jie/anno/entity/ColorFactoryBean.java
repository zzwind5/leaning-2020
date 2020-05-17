package com.jie.anno.com.jie.anno.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 17:15
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
