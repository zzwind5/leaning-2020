package com.jie.demo.job;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.jie.demo.job.impl.FileBackupJob;
import com.jie.demo.job.model.FileCustom;

public class MainJob {

	private static final String ZOOKEEPER_SERVERS = "192.168.222.20:2181,192.168.222.30:2181,192.168.222.40:2181";

	private static final String NAMESPACE = "elastic-job-demo";

	public static void main(String[] args) {
		generateTestFiles();

		CoordinatorRegistryCenter coordinatorRegistryCenter = setUpRegistryCenter();

		startJob(coordinatorRegistryCenter);
	}

	private static CoordinatorRegistryCenter setUpRegistryCenter() {
		ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZOOKEEPER_SERVERS, NAMESPACE);
		zookeeperConfiguration.setSessionTimeoutMilliseconds(1000 * 10);

		CoordinatorRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
		zookeeperRegistryCenter.init();

		return zookeeperRegistryCenter;
	}

	private static void startJob(CoordinatorRegistryCenter registryCenter) {
		JobCoreConfiguration myjob = JobCoreConfiguration.newBuilder("myjob", "*/3 * * * * ?", 1).build();

		SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(myjob, FileBackupJob.class.getCanonicalName());

		new JobScheduler(registryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build()).init();
	}

	private static void generateTestFiles(){
		for(int i=0;i<100;i++){
			FileBackupJob.BACK_FILES.add(new FileCustom("my_file_" + i, false));
		}
		System.out.println("生产测试数据完成");
	}
}
