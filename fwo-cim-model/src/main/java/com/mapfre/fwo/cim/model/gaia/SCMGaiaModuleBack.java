package com.mapfre.fwo.cim.model.gaia;

import java.util.Map;

import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.SCMModuleContext;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public class SCMGaiaModuleBack extends SCMGaiaModule {
	
	@Builder 
	public SCMGaiaModuleBack(String id, 
			String name, 
			String scmPartialPath, 
			@Singular("addProperty") Map<String, String> properties,
			@Singular("addModuleContext") Map<ENV, SCMModuleContext> context, 
			String contextRoot) {
		super(id, name, scmPartialPath, properties, context, contextRoot);
	}
}
