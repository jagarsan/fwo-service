package com.mapfre.fwo.cim.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@JsonInclude(value=Include.NON_NULL) @JsonTypeInfo(use=Id.CLASS)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public abstract class ModelObject {

	protected String id;
}
