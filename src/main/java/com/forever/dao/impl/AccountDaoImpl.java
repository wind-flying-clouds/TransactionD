package com.forever.dao.impl;

import com.forever.dao.AccountDao;
import com.forever.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by: Zhaoliting
 * description: 持久层实现类
 * created time: 2021/7/13 23:29
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update("update account set money = ? where id = ?", account.getMoney(), account.getId());
	}

	@Override
	public Account queryAccount(String name) {
		List<Account> query = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), name);
		if (CollectionUtils.isEmpty(query)) {
			return null;
		}
		if (query.size() > 1) {
			throw new RuntimeException("参数不唯一");
		}
		return query.get(0);
	}
}
