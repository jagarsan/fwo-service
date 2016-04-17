package com.mapfre.fwo.service.json;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMModuleContext;
import com.mapfre.fwo.cim.model.SCMProject;
import com.mapfre.fwo.cim.model.WasModuleContext;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModuleBack;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModuleFront;

public class SCMProjectSerializationTest {

	
	@Test
	public void testCompleteModel() throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		SCMProject<SCMModule> project = buildModel();
		String projectAsString = mapper.writeValueAsString(project);
		System.out.println(projectAsString);
		@SuppressWarnings("unchecked")
		SCMProject<SCMModule> deserializedProject = mapper.readValue(projectAsString, project.getClass());
		
		Assert.assertEquals(project, deserializedProject);
	}

	private SCMProject<SCMModule> buildModel() {
		SCMModuleContext moduleEDIC = WasModuleContext.builder()
				.contextRoot("EDIC/moduleContextRoot")
				.classLoaderMode("parentFirst")
				.addLibrary("Library1")
				.addLibrary("Library2")
				.addLibrary("Library3")
				.addProperty("propC1", "val1")
				.addProperty("propC2", "val2")
				.addProperty("propC3", "val3")
				.addProperty("propC4", "val4")
				.build();
		SCMModuleContext modulePRE = WasModuleContext.builder()
				.contextRoot("PRE/moduleContextRoot")
				.classLoaderMode("parentFirst")
				.addLibrary("Library1")
				.addLibrary("Library2")
				.addLibrary("Library3")
				.addProperty("propC1", "val1")
				.addProperty("propC2", "val2")
				.addProperty("propC3", "val3")
				.addProperty("propC4", "val4")
				.build();
		SCMModuleContext modulePRO = WasModuleContext.builder()
				.contextRoot("PRO/moduleContextRoot")
				.classLoaderMode("parentFirst")
				.addLibrary("Library1")
				.addLibrary("Library2")
				.addLibrary("Library3")
				.addProperty("propC1", "val1")
				.addProperty("propC2", "val2")
				.addProperty("propC3", "val3")
				.addProperty("propC4", "val4")
				.build();
		SCMGaiaModuleBack moduleBack = SCMGaiaModuleBack.builder()
				.name("GaiaBackModule")
				.contextRoot("BackContextRoot")
				.scmPartialPath("Back/partial/path")
				.addProperty("prop1", "val1")
				.addProperty("prop2", "val2")
				.addModuleContext(ENV.EDIC, moduleEDIC)
				.addModuleContext(ENV.PRE, modulePRE)
				.addModuleContext(ENV.PRO, modulePRO)
				.build();
		SCMGaiaModuleFront moduleFront = SCMGaiaModuleFront.builder()
				.name("GaiaFrontModule")
				.contextRoot("FrontContextRoot")
				.projectName("FrontProjectName")
				.langs("FrontLangs,en,es")
				.scmPartialPath("Front/partial/path")
				.addBackModule(moduleBack)
				.addProperty("prop1", "val1")
				.addProperty("prop2", "val2")
				.addModuleContext(ENV.EDIC, moduleEDIC)
				.addModuleContext(ENV.PRE, modulePRE)
				.addModuleContext(ENV.PRO, modulePRO)
				.build();
		SCMProject<SCMModule> project = SCMProject.builder()
				.name("Project")
				.scmPath("ProjectScmPath")
				.addModule(moduleBack)
				.addModule(moduleFront)
				.build();
		return project;
	}
}
