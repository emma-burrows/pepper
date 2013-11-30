package com.pepper.resources;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An entity representing a row in the 'drugs' table of the database, i.e. this
 * entity represents a drug.
 * @author Ross Laidlaw
 */
@Entity
@Table(name="drugs")
public class DrugEntity
{
  private String name;
  private String formula;
  private String weight;
  private String cas;
  private String atc;
  private String unii;
  private String imageName;

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
   * Gets the CAS number.
   * @return the CAS number
   */
  public String getCas()
  {
    return cas;
  }

  /**
   * Gets the ATC code.
   * @return the ATC code
   */
  public String getAtc()
  {
    return atc;
  }

  /**
   * Gets the UNII identifier.
   * @return the UNII identifier
   */
  public String getUnii()
  {
    return unii;
  }

  /**
   * Gets the imageName.
   * @return the imageName
   */
  public String getImageName()
  {
    return imageName;
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

  /**
   * Sets the CAS number.
   * @param cas the CAS number to set
   */
  public void setCas(String cas)
  {
    this.cas = cas;
  }

  /**
   * Sets the ATC code.
   * @param atc the ATC code to set
   */
  public void setAtc(String atc)
  {
    this.atc = atc;
  }

  /**
   * Sets the UNII identifier.
   * @param unii the UNII identifier to set
   */
  public void setUnii(String unii)
  {
    this.unii = unii;
  }

  /**
   * Sets the imageName.
   * @param imageName the imageName to set
   */
  public void setImageName(String imageName)
  {
    this.imageName = imageName;
  }
}
