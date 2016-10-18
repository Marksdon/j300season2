package priv.xzc.season2.que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行取款业务
 * @author Administrator
 *
 */
public class Demo1 {

	public static void main(String[] args) {

		Queue<Request> queue = new ArrayDeque<>();
		for(int i = 0; i < 10; i ++){
			final int num = i;
			queue.offer(new Request() {
				@Override
				public void deposit() {
					System.out.println("第"+num+"个人，办理存款额度为："+ Math.random()*1000);
				}
			});
		}
		dealwith(queue);
		
	}

	public static void dealwith(Queue<Request> queue){
		Request request = null;
		while (null != (request = queue.poll())) {
			request.deposit();
		}
	}
	
	
}

interface Request{
	void deposit();
}
