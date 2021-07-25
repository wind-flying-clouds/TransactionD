package com.forever.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 观察者模式：事件，事件源，观察者(监听器):观察者监听事件源触发的事件
 * created by: Zhaoliting
 * description: 定义事件
 * created time: 2021/7/18 11:46
 */

public class MyApplicationEvent extends ApplicationEvent {

	@Getter
	private Object source;

	public MyApplicationEvent(Object source) {
		super(source);
		this.source = source;
	} 
	
}
