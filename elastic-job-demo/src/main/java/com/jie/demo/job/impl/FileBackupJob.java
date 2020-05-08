package com.jie.demo.job.impl;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.jie.demo.job.model.FileCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileBackupJob implements SimpleJob {

	private static final int FETCH_COUNT = 1;

	public static List<FileCustom> BACK_FILES = new ArrayList<>();

	@Override
	public void execute(ShardingContext shardingContext) {
		int count = shardingContext.getShardingTotalCount();
		System.out.println(String.format("分片数: %d", count));

		List<FileCustom> fileCustoms = fetchUnBackupFiles(FETCH_COUNT);

		backupFiles(fileCustoms);
	}

	private List<FileCustom> fetchUnBackupFiles(int count) {
		return BACK_FILES.stream()
					.filter(file -> !file.isBackup())
					.limit(1)
					.collect(Collectors.toList());
	}

	private void backupFiles(List<FileCustom> files) {
		files.forEach(item -> {
			System.out.println("备份文件: " + item.getName());
			item.setBackup(true);
		});
	}
}
