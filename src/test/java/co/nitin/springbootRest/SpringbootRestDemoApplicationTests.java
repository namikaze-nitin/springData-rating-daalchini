package co.nitin.springbootRest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRestDemoApplicationTests {

	
	Lock sequential = new ReentrantLock();
	
	@Test
	public void contextLoads() {
	}
}
