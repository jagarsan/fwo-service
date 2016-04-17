package com.mapfre.fwo.cim.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor @ToString(callSuper=true)
public abstract class SCMModuleContext extends ModelObject {
	
	protected Map<String, String> properties;
	@Setter(AccessLevel.PROTECTED) protected List<Software> software;
	
	protected SCMModuleContext(String id, Map<String, String> properties, List<Software> software) {
		super(id);
		this.properties = properties!=null? properties : new HashMap<String, String>();
		this.software = software!=null? software : new ArrayList<Software>();
	}	
}
