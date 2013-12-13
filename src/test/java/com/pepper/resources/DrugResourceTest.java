package com.pepper.resources;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.pepper.domain.DrugResource;

/**
 * Implements tests for the {@link DrugResource} class.
 * @author Ross Laidlaw
 */
public class DrugResourceTest
{
  /**
   * Tests that {@link DrugResource drug resources} are marshalled to the
   * expected XML format.
   * @throws IOException if {@link Diff} constructor fails
   * @throws JAXBException if {@link JAXBContext} or {@link Marshaller} fail
   * @throws SAXException if {@link Diff} constructor fails
   */
  @Test
  public void testXmlMarshalling() throws IOException, JAXBException, SAXException
  {
    String drugName = "paracetamol";
    String expectedXml =
      "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
      + "<drug>"
      + "<name>" + drugName + "</name>"
      + "</drug>";
    DrugResource resource = new DrugResource(drugName);
    JAXBContext context = JAXBContext.newInstance(resource.getClass());
    Marshaller marshaller = context.createMarshaller();
    StringWriter writer = new StringWriter();
    marshaller.marshal(resource, writer);

    XMLUnit.setIgnoreWhitespace(true);
    XMLUnit.setIgnoreComments(true);
    XMLUnit.setIgnoreAttributeOrder(true);
    Diff diff = new Diff(expectedXml, writer.toString());
    assertTrue("Differences found between expected XML and output XML: "
      + diff.toString(), diff.identical());
  }
}
