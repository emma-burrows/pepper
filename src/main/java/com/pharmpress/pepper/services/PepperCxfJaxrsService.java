package com.pharmpress.pepper.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Ross Laidlaw
 * @version $Id$
 */
public class PepperCxfJaxrsService
{
  @GET
  @Path("test")
  @Produces({"text/plain"})
  public String testGet()
  {
    return "Test!!!";
  }
}
