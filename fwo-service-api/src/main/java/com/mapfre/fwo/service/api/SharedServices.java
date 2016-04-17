package com.mapfre.fwo.service.api;

public interface SharedServices {

	/**
	 * 
	 * @param processId
	 * @param params
	 * @return
	 */
	CheckOutResult checkOut(String processId, CheckOutParameters params);

	/**
	 * 
	 * @param processId
	 * @param params
	 * @return
	 */
	ExtractProjectResult extractProject(String processId, ExtractProjectParameters params);

	/**
	 * 
	 * @param subprocessId
	 * @param params
	 * @return
	 */
	BuildModuleResult buildModule(String subprocessId, BuildModuleParameters params);

}