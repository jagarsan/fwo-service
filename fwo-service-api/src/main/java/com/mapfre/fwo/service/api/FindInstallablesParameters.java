package com.mapfre.fwo.service.api;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMProject;

public class FindInstallablesParameters {
	public SCMProject<SCMModule> project;
	public SCMModule module;
}
