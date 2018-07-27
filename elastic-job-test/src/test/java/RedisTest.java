import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiaoyao.li  2018/7/5 18:08
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test(){
		redisTemplate.opsForValue().set("aaa", "111");
	}
}
