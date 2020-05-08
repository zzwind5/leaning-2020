package com.jie.demo.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileCustom {

	private String name;

	private boolean backup = false;
}
