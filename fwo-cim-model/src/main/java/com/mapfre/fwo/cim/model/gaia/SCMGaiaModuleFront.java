package com.mapfre.fwo.cim.model.gaia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.SCMModuleContext;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public class SCMGaiaModuleFront extends SCMGaiaModule {

	protected String langs;
	protected String projectName;
	@Setter(AccessLevel.PROTECTED) 
	protected List<SCMGaiaModuleBack> sCMGaiaModuleBack;

	@Builder
	protected SCMGaiaModuleFront(String id, String name, String scmPartialPath,
			@Singular("addProperty") Map<String, String> properties, 
			@Singular("addModuleContext") Map<ENV, SCMModuleContext> context,
			@Singular("addBackModule") List<SCMGaiaModuleBack> sCMGaiaModuleBack,
			String contextRoot, 
			String langs, 
			String projectName) {
		super(id, name, scmPartialPath, properties, context, contextRoot);
		this.langs = langs;
		this.projectName = projectName;
		this.sCMGaiaModuleBack = sCMGaiaModuleBack!=null? sCMGaiaModuleBack : new ArrayList<SCMGaiaModuleBack>();
	};
	

	
}
