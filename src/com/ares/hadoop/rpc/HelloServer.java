package com.ares.hadoop.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;
import org.apache.log4j.Logger;

public class HelloServer implements HelloProtocol {
	
	private static final Logger LOGGER = Logger.getLogger(HelloServer.class);

	@Override
	public String helloMethod(String name) {
		// TODO Auto-generated method stub
		LOGGER.debug("name: " + name);
		return "Hello, " + name;
	}
	
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		Builder builder = new RPC.Builder(new Configuration());
		String bindAddress = "HADOOP-NODE1";
		int port = 8888;
		builder.setBindAddress(bindAddress)
			.setPort(8888)
			.setProtocol(HelloProtocol.class)
			.setInstance(new HelloServer());
		Server server = builder.build();
		LOGGER.debug("Server start to listen on " + port);
		server.start();
	}

}
