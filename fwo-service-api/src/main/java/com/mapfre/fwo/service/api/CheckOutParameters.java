package com.mapfre.fwo.service.api;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMProject;

public class CheckOutParameters {
	public SCMProject<SCMModule> project;
	public String optionalModule;
}
