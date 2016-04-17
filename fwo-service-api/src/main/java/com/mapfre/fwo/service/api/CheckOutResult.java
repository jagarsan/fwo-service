package com.mapfre.fwo.service.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CheckOutResult {

	private final String code;
    private final String msg;
 
    public CheckOutResult(String id, String content) {
        this.code = id;
        this.msg = content;
    }
 
    public String getId() {
        return this.code;
    }
 
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The path for the checkout", required = true)
    public String getContent() {
        return this.msg;
    }
}
