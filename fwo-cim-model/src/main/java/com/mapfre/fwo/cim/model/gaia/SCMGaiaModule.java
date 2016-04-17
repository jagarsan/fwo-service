package com.mapfre.fwo.cim.model.gaia;

import java.util.Map;

import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.SCMModuleContext;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public abstract class SCMGaiaModule extends SCMModule {

	@NonNull protected String contextRoot;

	protected SCMGaiaModule(String id, String name, String scmPartialPath, Map<String, String> properties, Map<ENV, SCMModuleContext> context, String contextRoot) {
		super(id, name, scmPartialPath, properties, context);
		this.contextRoot = contextRoot;
	}
	
}
