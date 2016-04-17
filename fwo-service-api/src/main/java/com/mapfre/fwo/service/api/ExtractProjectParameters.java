package com.mapfre.fwo.service.api;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMProject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ExtractProjectParameters {
	protected SCMProject<SCMModule> project;
}
