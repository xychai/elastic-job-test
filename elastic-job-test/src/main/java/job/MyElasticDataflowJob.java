package job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyao.li  2018/7/27 14:30
 * @Description
 */
public class MyElasticDataflowJob implements DataflowJob<Object> {

	@Override
	public List<Object> fetchData(ShardingContext shardingContext) {
		List<Object> objs = new ArrayList<Object>();
		long time = System.currentTimeMillis();
		objs.add(time);
		return objs;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<Object> list) {
		System.out.println("dataFlow2"+list.get(0));
	}
}
