package com.mapfre.fwo.cim.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public class JBossModuleContext extends JEEModuleContext {

	@Builder
	protected JBossModuleContext(String id, 
			String contextRoot, 
			@Singular("addProperty") Map<String, String> properties, 
			@Singular("addSoftware") List<Software> software,
			@Singular("addLibrary") List<String> libraries) {
		super(id, properties, software, contextRoot, libraries);
	}
}
