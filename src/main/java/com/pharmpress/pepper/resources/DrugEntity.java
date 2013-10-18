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
  private String formula;
  private String weight;

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
   * Gets the formula.
   * @return the formula
   */
  public String getFormula()
  {
    return formula;
  }

  /**
   * Gets the weight.
   * @return the weight
   */
  public String getWeight()
  {
    return weight;
  }

  /**
   * Sets the name.
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the formula.
   * @param formula the formula to set
   */
  public void setFormula(String formula)
  {
    this.formula = formula;
  }

  /**
   * Sets the weight.
   * @param weight the weight to set
   */
  public void setWeight(String weight)
  {
    this.weight = weight;
  }
}
