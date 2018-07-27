package job;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @author xiaoyao.li  2018/7/27 14:32
 * @Description
 */
public class JobDemo {

	public static void main(String[] args) {
		CoordinatorRegistryCenter center = createRegistryCenter();
//		new JobScheduler(center, createJobConfiguration()).init();
		new JobScheduler(center, createJobConfiguration2()).init();
	}

	private static CoordinatorRegistryCenter createRegistryCenter() {
		CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181", "elastic-job-demo"));
		regCenter.init();
		return regCenter;
	}

	private static LiteJobConfiguration createJobConfiguration() {
		// 创建作业配置
		// ...

		// 定义作业核心配置
		JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration
				.newBuilder("demoSimpleJobTest", "0/15 * * * * ?", 3).build();
		// 定义SIMPLE类型配置
		SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyElasticJob.class.getCanonicalName());
		// 定义Lite作业根配置
		LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
		return simpleJobRootConfig;
	}

	private static LiteJobConfiguration createJobConfiguration2() {
		// 创建作业配置
		// ...

		// 定义作业核心配置
		JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration
				.newBuilder("demoDataflowJob3", "0/32 * * * * ?", 1).build();
		// 定义SIMPLE类型配置
		DataflowJobConfiguration jobConfiguration = new DataflowJobConfiguration(simpleCoreConfig,
				MyElasticDataflowJob.class.getCanonicalName(), false);
		// 定义Lite作业根配置
		LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(jobConfiguration).build();
		return simpleJobRootConfig;
	}

}
