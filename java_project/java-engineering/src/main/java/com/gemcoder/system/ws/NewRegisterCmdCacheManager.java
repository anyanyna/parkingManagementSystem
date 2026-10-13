package com.gemcoder.system.ws;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 设备注册命令信息
 * @author jiang
 *
 */
public class NewRegisterCmdCacheManager {
	private static NewRegisterCmdCacheManager _self;
	private ArrayBlockingQueue<String> cmds = new ArrayBlockingQueue<>(1000);

	private NewRegisterCmdCacheManager() {
	}

	public static NewRegisterCmdCacheManager getInstance() {
		synchronized (NewRegisterCmdCacheManager.class) {
			if (_self == null) {
				_self = new NewRegisterCmdCacheManager();
			}
		}
		return _self;
	}

	public String take() throws InterruptedException {
		return cmds.take();
	}

	public String peek() throws InterruptedException {
		return cmds.peek();
	}

	public String pool(long timeout, TimeUnit unit) throws InterruptedException {
		return cmds.poll(timeout, unit);
	}

	public void add(String cmd) {
		cmds.add(cmd);
	}
}
