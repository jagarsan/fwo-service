package com.mapfre.fwo.cim.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data @EqualsAndHashCode(callSuper=true) @NoArgsConstructor
public class SCMProject<M extends SCMModule> extends ModelObject {

	private String name;
	private String scmPath;
	private String version;
	private List<SCMProject<M>> projectDependencies;
	private List<M> modules;
	
	@Builder
	protected SCMProject(String id, String name, String scmPath, String version, 
			@Singular("addProject") List<SCMProject<M>> projectDependencies,
			@Singular("addModule") List<M> modules) {
		super(id);
		this.name = name;
		this.scmPath = scmPath;
		this.version = version;
		this.projectDependencies = projectDependencies!=null? projectDependencies : new ArrayList<SCMProject<M>>();
		this.modules = modules!=null? modules : new ArrayList<M>();
	}
}
