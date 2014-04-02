package com.arithmeticprotobuf.rest.controller;


import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.arithmeticprotobuf.domain.OperationData;
import com.arithmeticprotobuf.domain.OperationData.Operation;

public class ArithmeticController implements Callable {
		
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		OperationData operationData = OperationData.newBuilder()
				.setOperatorOne(1d)
				.setOperatorTwo(1d)
				.setOperation(Operation.sum)
				.build();
		return operationData.toByteArray();
	}

}
