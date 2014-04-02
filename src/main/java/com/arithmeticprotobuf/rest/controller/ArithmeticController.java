package com.arithmeticprotobuf.rest.controller;


import org.mule.api.MuleEventContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.mule.api.lifecycle.Callable;

import com.arithmeticprotobuf.domain.OperationData;
import com.arithmeticprotobuf.domain.OperationData.Operation;

@Path("/")
public class ArithmeticController implements Callable {
	
	@GET
	@Path("calc")
	public Response get(){
		OperationData operationData = OperationData.newBuilder()
				.setOperatorOne(1d)
				.setOperatorTwo(1d)
				.setOperation(Operation.sum)
				.build();
		 return Response.ok(operationData.toByteArray(),MediaType.APPLICATION_OCTET_STREAM).status(200).build();	
	}
		
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		OperationData operationData = OperationData.newBuilder()
				.setOperatorOne(1d)
				.setOperatorTwo(1d)
				.setOperation(Operation.sum)
				.build();
		System.out.println("O numero é"+operationData);
		return operationData.toByteArray();
	}

}
