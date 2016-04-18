package com.mapfre.fwo.service.front;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontController {

	@Autowired
	ServiceLocator locator;
	
	final String scheme = "http";
	final String server = "localhost";
	
	@RequestMapping(path="/{arq}/{version}/**", consumes="application/json", produces = "application/json")
	@ResponseBody
	public String frontRest(@RequestBody String body, HttpMethod method, HttpServletRequest request,
			HttpServletResponse response, @PathVariable String arq, @PathVariable String version) throws URISyntaxException {
		URI uri = lookupService(request, arq, version);
		return invoke(uri, method, body, response);
	}

	private URI lookupService(HttpServletRequest request, String arq, String version) throws URISyntaxException {
		int port = locator.getServicePort(arq, version);
		String requestUri = getTargetRequestURI(request.getRequestURI(), arq, version);
		return new URI(scheme, null, server, port, requestUri, request.getQueryString(), null);
	}

	private String getTargetRequestURI(String requestURI, String arq, String version) {
		int remainderPos = arq.length() + version.length() + 4;
		String remainderURI = requestURI.substring(remainderPos);
		return new StringBuilder("/").append(arq).append("/").append(remainderURI).toString();
	}

	private String invoke(URI uri, HttpMethod method, String body, HttpServletResponse response) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> httpEntity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> responseEntity = 
			restTemplate.exchange(uri, method, httpEntity, String.class);
		return responseEntity.getBody();
	}
}
