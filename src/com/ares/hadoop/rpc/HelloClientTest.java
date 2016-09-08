package com.ares.hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloClientTest {
	private static final Logger LOGGER = Logger.getLogger(HelloClientTest.class);
	
	@Before
	public void setUp() {
	}
	@After
	public void tearDown() {
	}
	
	@Test
	public void testHello() throws IOException {
		// TODO Auto-generated method stub 
		LOGGER.debug("RPCClientTest: testHello");
		String bindAddress = "HADOOP-NODE1";
		int port = 8888;
		InetSocketAddress addr = new InetSocketAddress(bindAddress, port);
		HelloProtocol proxy = RPC.getProxy(
				HelloProtocol.class, HelloProtocol.versionID, 
				addr, new Configuration());
		String resp = proxy.helloMethod("JunneYang");
		LOGGER.debug(resp);
		resp = proxy.helloMethod("Ares");
		LOGGER.debug(resp);
	}
}
