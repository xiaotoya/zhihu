package com.xiaotoya.zhihu;

import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ZhihuApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void testFindByUsername() {
		User user = userMapper.findByUsername("eric");
		System.out.println(user);
	}

	@Test
	void testPasswordEncoder() {
		String encoder1 = passwordEncoder.encode("123");
		System.out.println(encoder1);
		System.out.println(passwordEncoder.matches("123", "$2a$10$tfE6QZHLG9YaI4ukAUS7teiriw9cbxqlPWycixsXVaCCK57IO9JwC"));
	}

}
