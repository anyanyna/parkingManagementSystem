package com.gemcoder.system.ws;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class SessionCacheManager {
	private static SessionCacheManager _self;
	private ConcurrentHashMap<String,ExtendSession> cache=new ConcurrentHashMap<>();

	private SessionCacheManager() {
	}
	public static SessionCacheManager getInstance() {
		synchronized (SessionCacheManager.class) {
			if (_self == null) {
				_self = new SessionCacheManager();
			}
		}
		return _self;
	}
	public void forEach(BiConsumer<? super String, ? super ExtendSession> object) {
		cache.forEach(object);
		
	}
	public ExtendSession remove(String k) {
		// TODO Auto-generated method stub
		return cache.remove(k);
	}
	public ExtendSession get(String camId) {
		// TODO Auto-generated method stub
		return cache.get(camId);
	}
	public ExtendSession put(String cam_ip, ExtendSession extendSession) {
		// TODO Auto-generated method stub
		return cache.put(cam_ip, extendSession);
	}
	public int currentSize() {
		return cache.size();
	}
}
