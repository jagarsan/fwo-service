package com.mapfre.fwo.cim.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public abstract class SCMModule extends ModelObject {
	
	protected String name;
	protected String scmPartialPath;
	@NonNull @Singular protected Map<String, String> properties;
	@Setter(AccessLevel.PROTECTED) @Singular 
	protected Map<ENV, SCMModuleContext> contexts;
	
	protected SCMModule(String id, String name, String scmPartialPath, Map<String, String> properties, Map<ENV, SCMModuleContext> context) {
		super(id);
		this.name = name;
		this.scmPartialPath = scmPartialPath;
		this.properties = properties!=null? properties : new HashMap<String, String>();
		this.contexts = context!=null? context : new HashMap<ENV, SCMModuleContext>();
	}
}
