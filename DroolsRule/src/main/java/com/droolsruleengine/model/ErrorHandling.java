package com.droolsruleengine.model;

import lombok.Data;

@Data
public class ErrorHandling {

	private Status status;
	//
	private String message;
	//
	private Object data;

}