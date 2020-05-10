package com.jie.demo.job.config;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.jie.demo.job.impl.FileBackupJob;
import com.jie.demo.job.impl.FileBackupJobDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class ElasticJobConfig {

//	@Autowired
//	private FileBackupJobDb fileBackupJob;


	@Bean(initMethod = "init")
	public CoordinatorRegistryCenter coordinatorRegistryCenter(@Value("${zk.servers}") String serverLists,
															   @Value("${zk.namespace}") String nameSpace) {
		ZookeeperConfiguration zkConfiguration = new ZookeeperConfiguration(serverLists, nameSpace);
		zkConfiguration.setSessionTimeoutMilliseconds(1000 * 60);
		return new ZookeeperRegistryCenter(zkConfiguration);
	}

	@Bean(initMethod = "init")
	public SpringJobScheduler springJobScheduler(CoordinatorRegistryCenter registryCenter) {
//		return new SpringJobScheduler(new FileBackupJob(), registryCenter,
//				createLiteJobConfiguration(FileBackupJobDb.class, "*/3 * * * * ?", 3,
//						"0=doc,1=mp4,2=java"));

		return new SpringJobScheduler(new FileBackupJob(), registryCenter, createLiteJobConfiguration(FileBackupJob.class,
				"*/3 * * * * ?", 3, null));
//		return new SpringJobScheduler(new FileBackupJob(), registryCenter,
//				createLiteJobConfiguration(FileBackupJob.class, "*/3 * * * * ?", 3, null));
	}




	private LiteJobConfiguration createLiteJobConfiguration(Class jobClass, String cronStr, int shard, String shardParam) {
		JobCoreConfiguration.Builder builder = JobCoreConfiguration.newBuilder(jobClass.getName(), cronStr, shard);

		if ( !StringUtils.isEmpty(shardParam) ) {
			builder.shardingItemParameters(shardParam);
		}

		JobCoreConfiguration build = builder.build();

		SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(
				build, jobClass.getCanonicalName());

		return LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build();
	}

}
