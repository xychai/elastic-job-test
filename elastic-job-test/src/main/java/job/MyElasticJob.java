package job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author xiaoyao.li  2018/7/27 14:44
 * @Description  简单的JOB
 */
public class MyElasticJob implements SimpleJob {
	@Override
	public void execute(ShardingContext context) {
		switch (context.getShardingItem()) {
			case 0:
				System.out.println("Hi~~~~~~~~~~~~~0");
				break;
			case 1:
				System.out.println("Hi~~~~~~~~~~~~~1");
				break;
			case 2:
				System.out.println("Hi~~~~~~~~~~~~~2");
				break;
			case 3:
				System.out.println("Hi~~~~~~~~~~~~~3");
				break;
			case 4:
				System.out.println("Hi~~~~~~~~~~~~~4");
				break;
			case 5:
				System.out.println("Hi~~~~~~~~~~~~~5");
				break;
			case 6:
				System.out.println("Hi~~~~~~~~~~~~~6");
				break;
			case 7:
				System.out.println("Hi~~~~~~~~~~~~~7");
				break;
			case 8:
				System.out.println("Hi~~~~~~~~~~~~~8");
				break;
			case 9:
				System.out.println("Hi~~~~~~~~~~~~~9");
				break;
			case 10:
				System.out.println("Hi~~~~~~~~~~~~~10");
				break;
			// case n: ...
		}
	}
}
