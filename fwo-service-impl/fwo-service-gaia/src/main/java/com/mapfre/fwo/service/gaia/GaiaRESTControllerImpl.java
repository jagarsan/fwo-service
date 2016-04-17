package com.mapfre.fwo.service.gaia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mapfre.fwo.cim.model.ENV;
import com.mapfre.fwo.cim.model.WasModuleContext;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModule;
import com.mapfre.fwo.service.api.ApplyModuleConfParameters;
import com.mapfre.fwo.service.api.ApplyModuleConfResult;
import com.mapfre.fwo.service.api.DeployModuleParameters;
import com.mapfre.fwo.service.api.DeployModuleResult;
import com.mapfre.fwo.service.api.ExtractModuleParameters;
import com.mapfre.fwo.service.api.ExtractModuleResult;
import com.mapfre.fwo.service.api.FindInstallablesParameters;
import com.mapfre.fwo.service.api.FindInstallablesResult;
import com.mapfre.fwo.service.api.GaiaServices;
import com.mapfre.fwo.service.api.ValidateModuleParameters;
import com.mapfre.fwo.service.api.ValidateModuleResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author jagarcia
 *
 */
@RestController
@RequestMapping("/gaia")
public class GaiaRESTControllerImpl implements GaiaServices {

	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.gaia.AGaiaController#extractGaiaModule(java.lang.String, com.mapfre.fwo.service.shared.ExtractModuleParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{processId}/extractModule", consumes="application/json", produces = "application/json")
    @ApiOperation(value = "extractGaiaModule", nickname = "extractGaiaModule")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "processId", value = "Process' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Extract Module Parameters", required = true, dataType = "ExtractModuleParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ExtractModuleResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ExtractModuleResult extractGaiaModule(
    		@PathVariable("processId") String processId,
    		@RequestBody(required=true) ExtractModuleParameters params  		
    	) {
        return new ExtractModuleResult(buildMockModel((SCMGaiaModule) params.getModule()));
    }

	private SCMGaiaModule buildMockModel(SCMGaiaModule module) {
		Map<String,String> commonProperties = new HashMap<>();
		commonProperties.put("prop1", "propVal1");
		commonProperties.put("prop2", "propVal2");
		List<String> commonLibs = new ArrayList<>(2);
		commonLibs.add("Lib1");
		commonLibs.add("Lib2");
		module.setContextRoot("moduleContextRoot");
		module.setProperties(commonProperties);
		module.getContexts().put(ENV.EDIC, WasModuleContext.builder()
				.contextRoot("EDICModuleContextRoot")
				.classLoaderMode("parentFirst")
				.libraries(commonLibs)
				.properties(commonProperties)
				.addProperty("propEDIC1", "propEDICVal1")
				.build());
		module.getContexts().put(ENV.INT, WasModuleContext.builder()
				.contextRoot("INTModuleContextRoot")
				.classLoaderMode("parentFirst")
				.libraries(commonLibs)
				.properties(commonProperties)
				.addProperty("propINT1", "propINTVal1")
				.addProperty("propINT2", "propINTVal2")
				.build());
		module.getContexts().put(ENV.PRE, WasModuleContext.builder()
				.contextRoot("PREmoduleContextRoot")
				.classLoaderMode("parentFirst")
				.libraries(commonLibs)
				.properties(commonProperties)
				.addProperty("propPRE1", "propPREVal1")
				.build());
		module.getContexts().put(ENV.PRO, WasModuleContext.builder()
				.contextRoot("PREmoduleContextRoot")
				.classLoaderMode("parentFirst")
				.libraries(commonLibs)
				.properties(commonProperties)
				.addProperty("propPRO1", "propPROVal1")
				.build());
		return module;
	}
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.gaia.AGaiaController#validateGaiaModule(java.lang.String, com.mapfre.fwo.service.shared.ValidateModuleParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{subprocessId}/validate", consumes="application/json", produces = "application/json")
    @ApiOperation(value = "validateGaiaModule", nickname = "validateGaiaModule")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "subprocessId", value = "Subprocess' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Validate Module Parameters", required = true, dataType = "ValidateModuleParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ValidateModuleResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ValidateModuleResult validateGaiaModule(
    		@PathVariable("subprocessId") String subprocessId,
    		@RequestBody(required=true) ValidateModuleParameters params  		
    	) {
        return new ValidateModuleResult();
    }
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.gaia.AGaiaController#findGaiaModuleInstallables(java.lang.String, com.mapfre.fwo.service.shared.FindInstallablesParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{subprocessId}/findInstallables", consumes="application/json", produces = "application/json")
    @ApiOperation(value = "findGaiaModuleInstallables", nickname = "findGaiaModuleInstallables")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "subprocessId", value = "Subprocess' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Find Gaia Module Installables Parameters", required = true, dataType = "FindInstallablesParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = FindInstallablesResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public FindInstallablesResult findGaiaModuleInstallables(
    		@PathVariable("subprocessId") String subprocessId,
    		@RequestBody(required=true) FindInstallablesParameters params  		
    	) {
        return new FindInstallablesResult();
    }
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.gaia.AGaiaController#applyGaiaModuleConfiguration(java.lang.String, com.mapfre.fwo.cim.model.ENV, com.mapfre.fwo.service.shared.ApplyModuleConfParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{subprocessId}/applyConf/{env}", consumes="application/json", produces = "application/json")
    @ApiOperation(value = "applyGaiaModuleConfiguration", nickname = "applyGaiaModuleConfiguration")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "subprocessId", value = "Subprocess' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "env", value = "Enviroment context to apply", required = true, dataType = "ENV", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Find Gaia Module Installables Parameters", required = true, dataType = "ApplyModuleConfParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ApplyModuleConfResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ApplyModuleConfResult applyGaiaModuleConfiguration(
    		@PathVariable("subprocessId") String subprocessId,
    		@PathVariable("env") ENV env,
    		@RequestBody(required=true) ApplyModuleConfParameters params  		
    	) {
        return new ApplyModuleConfResult();
    }
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.gaia.AGaiaController#deployGaiaModule(java.lang.String, com.mapfre.fwo.service.shared.DeployModuleParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{subprocessId}/deploy", consumes="application/json", produces = "application/json")
    @ApiOperation(value = "deployGaiaModule", nickname = "deployGaiaModule")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "subprocessId", value = "Subprocess' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Deploy Gaia Module Parameters", required = true, dataType = "DeployModuleParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ApplyModuleConfResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public DeployModuleResult deployGaiaModule(
    		@PathVariable("subprocessId") String subprocessId,
    		@RequestBody(required=true) DeployModuleParameters params  		
    	) {
        return new DeployModuleResult();
    }
}
