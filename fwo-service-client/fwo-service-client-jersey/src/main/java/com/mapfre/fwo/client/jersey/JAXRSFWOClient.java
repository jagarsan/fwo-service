package com.mapfre.fwo.client.jersey;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.mapfre.fwo.cim.model.SCMProject;
import com.mapfre.fwo.service.api.ExtractProjectParameters;
import com.mapfre.fwo.service.api.ExtractProjectResult;

public class JAXRSFWOClient {

	public static void main(String[] args) {

		ExtractProjectParameters params = new ExtractProjectParameters(
	        	SCMProject.builder()
	        		.name("testProject")
	        		.version("1.1.1")
	        		.id("testProject:1.1.1")
	        		.build());
		
		ExtractProjectResult f = ClientBuilder.newClient().target("http://localhost:8080/shared/101/extract").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(params,MediaType.APPLICATION_JSON_TYPE), ExtractProjectResult.class);

		System.out.println(f.toString());

	}

}
