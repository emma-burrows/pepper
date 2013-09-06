package com.pharmpress.pepper.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pharmpress.pepper.resources.DrugResource;

/**
 * A JAX-RS service class that handles HTTP requests.
 * @author Ross Laidlaw
 * @version $Id$
 */
public class PepperCxfJaxrsService
{
  /**
   * Returns an HTTP response containing a JAX-RS resource that represents a
   * drug, marshalled to the requested format.
   * @return an HTTP response containing a JAX-RS resource representing a drug
   */
  @GET
  @Path("drug")
  @Produces({"application/xml", "application/json"})
  public DrugResource getDrug()
  {
    return new DrugResource("Wonder Drug!");
  }
}
