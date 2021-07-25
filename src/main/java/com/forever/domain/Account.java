package com.forever.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by: Zhaoliting
 * description: ZHANGHU
 * created time: 2021/6/22 23:36
 */

@Data
public class Account implements Serializable {
	private int id;
	private String name;
	private BigDecimal money;
}
