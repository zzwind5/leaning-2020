package com.jie.demo.job.impl;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.jie.demo.job.model.FileCustom;
import com.jie.demo.job.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileBackupJobDb implements SimpleJob {

	private static final int FETCH_COUNT = 1;

	@Autowired
	private FileService fileService;

	@Override
	public void execute(ShardingContext shardingContext) {
//		int index = shardingContext.getShardingItem();
//		String type = shardingContext.getShardingParameter();
//
//		System.out.println(String.format("分片数: %d", index));
//
//		List<FileCustom> fileCustoms = fileService.fetchUnBackupFiles(type, FETCH_COUNT);
//
//		fileService.backupFiles(fileCustoms);
	}
}
