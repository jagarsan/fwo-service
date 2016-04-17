package com.mapfre.fwo.service.api;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMModuleContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class ApplyModuleConfParameters {
	public SCMModule module;
	public SCMModuleContext moduleContext;
}
