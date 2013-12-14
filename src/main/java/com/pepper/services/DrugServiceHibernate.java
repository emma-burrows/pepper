package com.pepper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pepper.dao.DrugDao;
import com.pepper.domain.DrugEntity;

/**
 * An implementation of the drug service for Hibernate.
 * @author Ross Laidlaw
 */
@Service
public class DrugServiceHibernate implements DrugService
{
  @Autowired
  private DrugDao drugDao;

  @Override
  @Transactional(readOnly = true)
  public List<DrugEntity> getAllByName(String name)
  {
    return drugDao.getAllByName(name);
  }

  @Override
  @Transactional(readOnly = true)
  public List<String> getAllNamesAsc()
  {
    return drugDao.getAllNamesAsc();
  }

  @Override
  @Transactional(readOnly = true)
  public long getCount()
  {
    return drugDao.getCount();
  }
}
