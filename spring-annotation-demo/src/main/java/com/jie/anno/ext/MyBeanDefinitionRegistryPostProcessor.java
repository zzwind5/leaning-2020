package com.jie.anno.ext;

import com.jie.anno.com.jie.anno.entity.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor ... BeanDefinitionRegistry count: " + registry.getBeanDefinitionCount());
		AbstractBeanDefinition blue = BeanDefinitionBuilder.genericBeanDefinition(Blue.class).getBeanDefinition();
//		registry.registerBeanDefinition("hello", blue);
		registry.removeBeanDefinition("blue");
		System.out.println(Arrays.asList(registry.getBeanDefinitionNames()));
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor ... BeanFactoryPost count: " + beanFactory.getBeanDefinitionCount());
	}
}
