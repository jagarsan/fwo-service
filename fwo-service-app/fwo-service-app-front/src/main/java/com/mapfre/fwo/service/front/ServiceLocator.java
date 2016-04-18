package com.mapfre.fwo.service.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class ServiceLocator {

	final String userDir = System.getProperty("user.home");
	final String repoPath = userDir + "/.m2/repository/";
	final String baseName = "fwo-service-app-";
	final String basePath = repoPath + "com/mapfre/fwo/" + baseName;
	
	Map<String, Integer> serversPorts = (new HashMap<String,Integer>());
	Map<Integer, Process> portsProcess = (new HashMap<Integer, Process>());
	AtomicInteger portCounter = new AtomicInteger(9001);
	
	public int getServicePort(String arq, String version) {
		try {
			String serviceKey = arq+"#"+version;
			return serversPorts.containsKey(serviceKey)?
					serversPorts.get(serviceKey)
					: startService(arq, version);
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* !TODO: Needs Synchronization! */
	private int startService(String arq, String version) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String jarName = baseName + arq + "-" + version + ".jar";
		String pathToJar = basePath + arq + "/" + version + "/" + jarName;
		int port = portCounter.getAndIncrement();
		Process serverProcess = startProcess(pathToJar, port);
		if(serverProcess.isAlive()){
			serversPorts.put(arq+"#"+version, port);
			portsProcess.put(port, serverProcess);
			Thread.sleep(6000L);
		}
		return port;
	}

	protected Process startProcess(String pathToJar, int port) throws IOException{
		return new ProcessBuilder(new String[]{
			"java",
			"-jar",
			pathToJar,
			"--server.port="+port
		})
				.inheritIO()
				.start();
	}

}
