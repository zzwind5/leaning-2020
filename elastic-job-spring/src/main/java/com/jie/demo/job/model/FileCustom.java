package com.jie.demo.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileCustom {

	private Integer id;

	private String name;

	private String type;

	private boolean backup = false;

	private String content;
}

