package com.arithmeticprotobuf.rest.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
		OperationData operationData = OperationData.getDefaultInstance();
		  URL url = new URL("http://localhost:8081/calc/");
		  HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		  //urlc.setDoInput(true);
		  urlc.setDoOutput(true);
		  urlc.setRequestMethod("GET");
		  urlc.setRequestProperty("Accept", "application/x-protobuf");
		  urlc.setRequestProperty("Content-Type", "application/x-protobuf");
		  operationData.writeTo(urlc.getOutputStream());
		  System.out.println(operationData.getOperatorOne());
		  
		  DefaultHttpClient client = new DefaultHttpClient();
		  HttpGet request = new HttpGet("http://localhost:8081/calc/");
		  HttpResponse response = client.execute(request);
		  //BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
	 	  //String line = '';
		  HttpClient httpclient = new HttpClient();
		  GetMethod httpget = new GetMethod("http://localhost:8081/calc/");
		  httpclient.executeMethod(httpget);
		  OutputStream entrada = new ByteArrayOutputStream();
		  entrada.write(httpget.getResponseBody());
		  
		  
		  operationData.writeTo(entrada);
		  System.out.println(operationData.getOperatorOne());

		  
		  
		  
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
