package com.forever.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * created by: Zhaoliting
 * description: 账户接口
 * created time: 2021/7/13 23:20
 */

public interface AccountService {
	/**
	 * 转账接口
	 * @param sourceName 
	 * @param targetName
	 * @param money
	 */
	void transFrom(String sourceName, String targetName, BigDecimal money);
}
