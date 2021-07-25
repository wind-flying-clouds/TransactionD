package com.forever.service.impl;

import com.forever.dao.AccountDao;
import com.forever.domain.Account;
import com.forever.event.MyApplicationEvent;
import com.forever.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * created by: Zhaoliting
 * description: 转账实现类
 * created time: 2021/7/13 23:23
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;
	
	//事件发布器
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	@Transactional
	public void transFrom(String sourceName, String targetName, BigDecimal money) {
		try {
			Account sourceAcc = accountDao.queryAccount(sourceName);
			Account targetAcc = accountDao.queryAccount(targetName);
			BigDecimal money1 = sourceAcc.getMoney().add(money);
			BigDecimal money2 = targetAcc.getMoney().subtract(money);
			if (money1.compareTo(BigDecimal.ZERO)< 0 || money2.compareTo(BigDecimal.ZERO)<0) {
				throw new RuntimeException("转账失败，账户余额不足");
			}
			sourceAcc.setMoney(money1);
			targetAcc.setMoney(money2);
			accountDao.updateAccount(sourceAcc);
			int a = 1 / 0;
			accountDao.updateAccount(targetAcc);
		} finally {
			HashMap<String, String> map = new HashMap<>();
			map.put("sourceName", sourceName);
			map.put("targetName", targetName);
			map.put("money", money.toString());
			//发布事件
			applicationEventPublisher.publishEvent(new MyApplicationEvent(map));
		}

	}
} 
