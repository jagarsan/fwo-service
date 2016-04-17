package com.mapfre.fwo.cim.model.gaia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.SCMModuleContext;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public class SCMGaiaModuleUnified extends SCMGaiaModule {

	protected List<SCMGaiaModuleFront> gaiaModule = new ArrayList<SCMGaiaModuleFront>();

	@Builder
	protected SCMGaiaModuleUnified(String id, 
			String name, 
			String scmPartialPath,
			@Singular("addProperty") Map<String, String> properties, 
			@Singular("addModuleContext") Map<ENV, SCMModuleContext> context, 
			String contextRoot) {
		super(id, name, scmPartialPath, properties, context, contextRoot);
	}
}
