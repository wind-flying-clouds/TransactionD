package com.forever.listener;

import com.forever.event.MyApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Map;

/**
 * created by: Zhaoliting
 * description: 事务事件监听器
 * created time: 2021/7/18 11:51
 */
@Component
public class MyTransactionalEventListener {

	/**
	 * 事务提交成功之后
	 * @param event
	 */
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void doSomething(MyApplicationEvent event) {
		//从事件对象中获取事件源
		Map<String, String> source = (Map) event.getSource();
		System.out.println(source.get("sourceName") + "给" + source.get("targetName") + "转了" + source.get("money") + "元," + "转账成功");
	}

	/**
	 * 事务失败之后做的事情
	 * @param event
	 */
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void doOtherThing(MyApplicationEvent event) {
		//从事件对象中获取事件源
		Map<String, String> source = (Map) event.getSource();
		System.out.println(source.get("sourceName") + "给" + source.get("targetName") + "转了" + source.get("money") + "元," + "转账失败");
	}
	
}
