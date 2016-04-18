package com.mapfre.fwo.client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMProject;
import com.mapfre.fwo.service.api.ExtractModuleParameters;
import com.mapfre.fwo.service.api.ExtractModuleResult;
import com.mapfre.fwo.service.api.ExtractProjectParameters;
import com.mapfre.fwo.service.api.ExtractProjectResult;

@SpringBootApplication
public class RestTemplateFWOClient implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateFWOClient.class);

    public static void main(String args[]) {
        SpringApplication.run(RestTemplateFWOClient.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        SCMProject<SCMModule> project = SCMProject.builder()
			.name("testProject")
			.version("1.1.1")
			.id("testProject:1.1.1")
			.build();
		ExtractProjectParameters params = new ExtractProjectParameters(project);
        ExtractProjectResult modulesResult = restTemplate.postForObject(
        		"http://localhost:9000/shared/0.0.1-SNAPSHOT/101/extract", params, ExtractProjectResult.class);
        log.info(modulesResult.toString());
        
        ExtractModuleParameters moduleParams = ExtractModuleParameters.builder()
        		.project(project)
        		.module(modulesResult.getModules().get(0))
        		.build();
//        ResponseEntity<ExtractModuleResult> postForEntity = restTemplate.postForEntity(
//        		"http://localhost:8080/gaia/101/extractModule", moduleParams, ExtractModuleResult.class);
//        log.info(postForEntity.toString());
        ExtractModuleResult moduleResult = restTemplate.postForObject(
        		"http://localhost:9000/gaia/0.0.1-SNAPSHOT/101/extractModule", moduleParams, ExtractModuleResult.class);
        log.info(moduleResult.toString());
        
    }
}