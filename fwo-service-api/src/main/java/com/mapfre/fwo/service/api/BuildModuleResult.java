package com.mapfre.fwo.service.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapfre.fwo.cim.model.Software;

import io.swagger.annotations.ApiModelProperty;

public class BuildModuleResult {
	
    public BuildModuleResult(List<Software> artifacts) {
		super();
		this.artifacts = artifacts;
	}

	@JsonProperty(required = true)
	@ApiModelProperty(notes = "the installables artifacts builded", required = true)
    public List<Software> artifacts;
}
