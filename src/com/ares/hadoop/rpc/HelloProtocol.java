package com.ares.hadoop.rpc;

public interface HelloProtocol {
	public static final long versionID = 1L;
	
	public String helloMethod(String name);
}
