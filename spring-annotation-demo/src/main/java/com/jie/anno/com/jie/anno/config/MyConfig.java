package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Person;
import com.jie.anno.dao.BookRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScan(value = "com.jie.anno", excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
//		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookRepo.class)
//})
//@ComponentScan(value = "com.jie.anno", includeFilters = {
//		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class),
//		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyFilter.class),
//}, useDefaultFilters = false)

@ComponentScan(value = "com.jie.anno", includeFilters = {
		@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyFilter.class),
}, useDefaultFilters = false)
public class MyConfig {

	@Bean("pp1")
	public Person person() {
		return new Person("pp1", 19);
	}
}
