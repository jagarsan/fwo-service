package com.mapfre.fwo.cim.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor  @ToString(callSuper=true)
public class WasModuleContext extends JEEModuleContext {

	protected String classLoaderMode;

	@Builder
	protected WasModuleContext(String id, 
			String contextRoot, 
			@Singular("addProperty") Map<String, String> properties, 
			@Singular("addSoftware") List<Software> software,
			@Singular("addLibrary") List<String> libraries, 
			String classLoaderMode) {
		super(id, properties, software, contextRoot, libraries);
		this.classLoaderMode = classLoaderMode;
	}
	
	
}
