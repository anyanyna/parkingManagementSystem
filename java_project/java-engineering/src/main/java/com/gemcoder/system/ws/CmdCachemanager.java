package com.gemcoder.system.ws;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CmdCachemanager {
	private static CmdCachemanager _self;
	private java.util.concurrent.BlockingQueue<Command> cmdList;
	private CmdCachemanager() {
		cmdList=new ArrayBlockingQueue<Command>(10_000);
	}
	public static CmdCachemanager getInstance() {
		synchronized (CmdCachemanager.class) {
			if (_self == null) {
				_self = new CmdCachemanager();
			}
		}
		return _self;
	}
	public void putCmd(Command cmd) {
		cmdList.add(cmd);
	}
	public Command getCmd() {
		try {
			return cmdList.poll(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			return null;
		}
	}
}
