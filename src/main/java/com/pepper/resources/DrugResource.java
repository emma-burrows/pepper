package com.pepper.resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A JAX-RS resource representing a drug.
 * @author Ross Laidlaw
 */
@XmlRootElement(name = "drug")
@XmlType(propOrder = {"name"})
@XmlAccessorType(XmlAccessType.NONE)
public class DrugResource
{
  private String name;



  /**
   * Default constructor required by JAXB.
   */
  public DrugResource()
  {
  }



  /**
   * Constructor that sets the name of the drug.
   * @param name the name of the drug
   */
  public DrugResource(String name)
  {
    this.name = name;
  }



  /**
   * Gets the name of the drug.
   * @return the name of the drug
   */
  @XmlElement(name = "name")
  public String getName()
  {
    return name;
  }
}
