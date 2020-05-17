package com.jie.anno.com.jie.anno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Value("张三")
	private String name;

	@Value("#{30-2}")
	private Integer age;

	@Value("${person.nickName}")
	private String nickName;
}
