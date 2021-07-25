package com.forever;

import com.config.Config;
import com.forever.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * created by: Zhaoliting
 * description: 测试类
 * created time: 2021/7/13 23:57
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {

	@Autowired
	private AccountService accountService;

	@org.junit.Test
	public void test() {
		accountService.transFrom("1", "2", new BigDecimal(-1000));
	}
	
	
}
