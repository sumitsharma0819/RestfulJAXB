package com.sumree.jersey.jaxb.main;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Main {

  public static void main(String[] args) {

    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    WebTarget target = client.target(getBaseURI());

    System.out.println("1: "+ target.path("rest").path("hello").request()

    .accept(MediaType.TEXT_PLAIN).get(Response.class)

    .toString());

    
    System.out.println("2: "+ target.path("rest").path("hello").request()

    .accept(MediaType.TEXT_PLAIN).get(String.class));

    
    System.out.println("3: "+ target.path("rest").path("hello").request()

    .accept(MediaType.TEXT_XML).get(String.class));

    
    System.out.println("4: "+ target.path("rest").path("hello").request()

    .accept(MediaType.TEXT_HTML).get(String.class));

  }

  private static URI getBaseURI() {

    return UriBuilder.fromUri("http://localhost:8080/RestExample").build();

  }
} 