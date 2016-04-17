package com.mapfre.fwo.service.api;

import java.util.List;

import com.mapfre.fwo.cim.model.SCMModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ExtractProjectResult {
	
	@Singular("addModule") protected List<SCMModule> modules;
	
}
