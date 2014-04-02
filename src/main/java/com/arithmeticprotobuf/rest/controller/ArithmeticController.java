package com.arithmeticprotobuf.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.arithmeticprotobuf.domain.Operations;
import com.arithmeticprotobuf.domain.Operations.OperationData;
import com.arithmeticprotobuf.domain.Operations.OperationData.Operation;


public class ArithmeticController implements Callable {
		
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		OperationData operationData = Operations.OperationData.newBuilder()
				.setOperatorOne(1d)
				.setOperatorTwo(1d)
				.setOperation(Operation.sum)
				.build();
		return operationData.toByteArray();
	}

}
