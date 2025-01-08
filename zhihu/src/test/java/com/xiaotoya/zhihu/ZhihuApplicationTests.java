package com.xiaotoya.zhihu;

import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZhihuApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void testFindByUsername() {
		User user = userMapper.findByUsername("eric");
		System.out.println(user);
	}

}
