package com.pepper.services;

import java.util.List;

import com.pepper.domain.DrugEntity;

/**
 * Interface for drug service objects.
 * @author Ross Laidlaw
 */
public interface DrugService
{
  /**
   * Gets all drugs with names like the supplied String.
   * @param name the name to match
   * @return a list of DrugEntity objects that have names like the supplied
   * String
   */
  public List<DrugEntity> getAllByName(String name);

  /**
   * Gets a list of all drug names in ascending order.
   * @return a list of all drug names in ascending order
   */
  public List<String> getAllNamesAsc();

  /**
   * Gets a count of the number of drugs stored in the database.
   * @return a count of the number of drugs stored in the database
   */
  public long getCount();
}
