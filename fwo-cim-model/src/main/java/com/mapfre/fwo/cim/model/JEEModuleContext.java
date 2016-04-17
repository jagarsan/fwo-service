package com.mapfre.fwo.cim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public abstract class JEEModuleContext extends SCMModuleContext {

	protected String contextRoot;
	protected List<String> libraries;

	protected JEEModuleContext(String id, Map<String, String> properties, List<Software> software, String contextRoot, List<String> libraries) {
		super(id, properties, software);
		this.contextRoot = contextRoot;
		this.libraries = libraries!=null? libraries : new ArrayList<String>();
	}	
	
}
