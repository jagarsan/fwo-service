package com.mapfre.fwo.cim.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper=true)
public class Software extends ModelObject {

	protected String dmlPath;
	protected String arch;
	protected String edition;
	protected String patch;
	protected String version;
	protected String vendor;
	
	@Builder
	protected Software(String id, String dmlPath, String arch, String edition, String patch, String version,
			String vendor) {
		super(id);
		this.dmlPath = dmlPath;
		this.arch = arch;
		this.edition = edition;
		this.patch = patch;
		this.version = version;
		this.vendor = vendor;
	}
}
