package com.arithmeticprotobuf.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.arithmeticprotobuf.domain.Operations;
import com.arithmeticprotobuf.domain.Operations.OperationData;
import com.arithmeticprotobuf.domain.Operations.OperationData.Operation;

@Path("/")
public class ArithmeticController {

	@GET
	@Path("calc")
	@Produces("application/x-protobuf")
    public Response getOperationData() {
		OperationData operationData = Operations.OperationData.newBuilder()
				.setOperatorOne(1d)
				.setOperatorTwo(1d)
				.setOperation(Operation.sum)
				.build();
		System.out.println("Chamando");
		return Response.ok(operationData.toByteArray(),MediaType.APPLICATION_OCTET_STREAM).status(200).build();
        
    }

}
