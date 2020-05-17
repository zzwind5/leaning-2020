package com.jie.anno.com.jie.anno.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(String.format("postProcessBeforeInitialization ... %s ===> %s",
				beanName, bean.getClass().getCanonicalName()));
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(String.format("postProcessAfterInitialization ... %s ===> %s",
				beanName, bean.getClass().getCanonicalName()));
		return bean;
	}
}
