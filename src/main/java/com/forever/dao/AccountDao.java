package com.forever.dao;

import com.forever.domain.Account;

/**
 * created by: Zhaoliting
 * description: 持久层
 * created time: 2021/7/13 23:25
 */

public interface AccountDao {
	/**
	 * 更新账户
	 * @param account
	 */
	void updateAccount(Account account);

	/**
	 * 查询账户
	 * @param name
	 * @return
	 */
	Account queryAccount(String name);
	
	
}
