package com.mapfre.fwo.service.shared;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mapfre.fwo.cim.model.SCMModule;
import com.mapfre.fwo.cim.model.Software;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModuleBack;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModuleFront;
import com.mapfre.fwo.cim.model.gaia.SCMGaiaModuleUnified;
import com.mapfre.fwo.service.api.BuildModuleParameters;
import com.mapfre.fwo.service.api.BuildModuleResult;
import com.mapfre.fwo.service.api.CheckOutParameters;
import com.mapfre.fwo.service.api.CheckOutResult;
import com.mapfre.fwo.service.api.ExtractProjectParameters;
import com.mapfre.fwo.service.api.ExtractProjectResult;
import com.mapfre.fwo.service.api.SharedServices;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/shared")
public class SharedRESTControllerImpl implements SharedServices {

	private static final String template = "%s/%s/%s:%s";
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.shared.ASharedController#checkOut(java.lang.String, com.mapfre.fwo.service.shared.CheckOutParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{processId}/checkout", consumes="application/json", produces = "application/json")
	@ApiOperation(value = "checkOut", nickname = "checkOut")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "processId", value = "Process' or subprocess' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Checkout Parameters", required = true, dataType = "CheckOutParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = CheckOutResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public CheckOutResult checkOut(
    		@PathVariable("processId") String processId,
    		@RequestBody(required=true) CheckOutParameters params  		
    	) {
        return new CheckOutResult(processId,
                String.format(template, 
                		params.project.getId(),
                		params.optionalModule!=null? params.optionalModule : "root",
                		processId));
    }
	
	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.shared.ASharedController#extractProject(java.lang.String, com.mapfre.fwo.service.shared.ExtractProjectParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{processId}/extract", consumes="application/json", produces = "application/json")
	@ApiOperation(value = "extractProject", nickname = "extractProject")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "processId", value = "Process' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Extract project parameters", required = true, dataType = "ExtractProjectParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ExtractProjectResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public ExtractProjectResult extractProject(
			@PathVariable("processId") String processId,
    		@RequestBody(required=true) ExtractProjectParameters params){
		SCMModule[] modules = new SCMModule[] {
				SCMGaiaModuleBack.builder().name("moduleBack").scmPartialPath("/moduleBack").build(),
				SCMGaiaModuleFront.builder().name("moduleFront").scmPartialPath("/moduleFront").build(),
				SCMGaiaModuleUnified.builder().name("moduleUnif").scmPartialPath("/moduleUnif").build()
		};
		return new ExtractProjectResult(Arrays.asList(modules) );
	}

	/* (non-Javadoc)
	 * @see com.mapfre.fwo.service.shared.ASharedController#buildModule(java.lang.String, com.mapfre.fwo.service.shared.BuildModuleParameters)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, path="/{subprocessId}/build", consumes="application/json", produces = "application/json")
	@ApiOperation(value = "buildModule", nickname = "buildModule")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "subprocessId", value = "Process' identifier", required = true, dataType = "string", paramType = "path"),
        @ApiImplicitParam(name = "params", value = "Build module parameters", required = true, dataType = "BuildModuleParameters", paramType = "body")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = BuildModuleResult.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	public BuildModuleResult buildModule(
			@PathVariable("subprocessId") String subprocessId,
    		@RequestBody(required=true) BuildModuleParameters params){
		Software[] artifacts = new Software[] {
				Software.builder().build(),
				Software.builder().build(),
				Software.builder().build()
		};
		return new BuildModuleResult(Arrays.asList(artifacts));
	}

}
