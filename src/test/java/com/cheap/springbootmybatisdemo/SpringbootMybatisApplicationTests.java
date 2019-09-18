package com.cheap.springbootmybatisdemo;

import com.cheap.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	private IUserService iUserService;

	@Test
	public void testUserInfo() {
		iUserService.findAllUser(1,5);
	}

}
