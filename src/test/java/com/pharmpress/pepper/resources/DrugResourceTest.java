package com.pharmpress.pepper.resources;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

/**
 * Implements tests for the {@link DrugResource} class.
 * @author Ross Laidlaw
 * @version $Id$
 */
public class DrugResourceTest
{
  /**
   * @throws JAXBException
   */
  @Test
  public void testXmlMarshalling() throws JAXBException
  {
    DrugResource resource = new DrugResource("Wonder Drug!");
    JAXBContext context = JAXBContext.newInstance(resource.getClass());
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(resource, System.out);
  }
}
