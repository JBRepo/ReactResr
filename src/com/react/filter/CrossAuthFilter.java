package com.react.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;


public class CrossAuthFilter implements ContainerResponseFilter {
	
	 @Override
	   public ContainerResponse filter(final ContainerRequest request,
	                      final ContainerResponse response) {	  
		  response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
	      response.getHttpHeaders().add("Access-Control-Allow-Headers",
	              "origin, content-type, accept, authorization");
	      response.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
	      response.getHttpHeaders().add("Access-Control-Allow-Methods",
	              "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      return response;
	   }	

}