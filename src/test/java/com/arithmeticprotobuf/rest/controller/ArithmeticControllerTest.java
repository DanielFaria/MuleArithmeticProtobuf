package com.arithmeticprotobuf.rest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;


import com.arithmeticprotobuf.domain.OperationData;
import com.google.protobuf.CodedOutputStream;

public class ArithmeticControllerTest {

	
  @Test
  public void testGetOperationData(){
	  try {
		  
		  DefaultHttpClient client = new DefaultHttpClient();
		  HttpGet request = new HttpGet("http://localhost:8081/calc/");
		  request.addHeader("accept","application/octet-stream");
		  HttpResponse response = client.execute(request);
		  System.out.println(response.getEntity().getContentType());
		  OperationData operationData = OperationData.parseFrom(response.getEntity().getContent());
		  Assert.assertEquals(operationData.getOperatorOne(), 1d);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
	
	
}
