package com.mapfre.fwo.service.api;

import com.mapfre.fwo.cim.model.ENV;

public interface GaiaServices {

	/**
	 * Extract Module Operation
	 * @param processId
	 * @param params
	 * @return
	 */
	ExtractModuleResult extractGaiaModule(String processId, ExtractModuleParameters params);

	/**
	 * 
	 * @param subprocessId
	 * @param params
	 * @return
	 */
	ValidateModuleResult validateGaiaModule(String subprocessId, ValidateModuleParameters params);

	/**
	 * 
	 * @param subprocessId
	 * @param params
	 * @return
	 */
	FindInstallablesResult findGaiaModuleInstallables(String subprocessId, FindInstallablesParameters params);

	/**
	 * 
	 * @param subprocessId
	 * @param env
	 * @param params
	 * @return
	 */
	ApplyModuleConfResult applyGaiaModuleConfiguration(String subprocessId, ENV env, ApplyModuleConfParameters params);

	/**
	 * 
	 * @param subprocessId
	 * @param params
	 * @return
	 */
	DeployModuleResult deployGaiaModule(String subprocessId, DeployModuleParameters params);

}