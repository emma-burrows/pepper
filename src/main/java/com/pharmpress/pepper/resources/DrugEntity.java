package com.pharmpress.pepper.resources;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ross Laidlaw
 */
@Entity
@Table(name="drugs")
public class DrugEntity
{
  private String name;

  /**
   * Default constructor used by Hibernate.
   */
  public DrugEntity()
  {
  }

  /**
   * Constructor that sets the name of the drug.
   * @param name the name of the drug
   */
  public DrugEntity(String name)
  {
    this.name = name;
  }

  /**
   * Gets the name.
   * @return the name
   */
  @Id
  public String getName()
  {
    return name;
  }

  /**
   * Sets the name.
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }
}
