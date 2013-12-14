package com.pepper.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pepper.domain.DrugEntity;

/**
 * An implementation of the drug DAO for Hibernate.
 * @author Ross Laidlaw
 */
@Repository
public class DrugDaoHibernate implements DrugDao
{
  @Autowired
  private SessionFactory sessionFactory;

  /**
   * Sets the session factory.
   * @param sessionFactory
   */
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional(readOnly = true)
  public List<DrugEntity> getAllByName(String name)
  {
    Query query = this.sessionFactory.getCurrentSession()
      .createQuery("from DrugEntity where name like :name order by name asc");
    query.setParameter("name", '%' + name + '%');

    // Generate a list of drugs and add this to a typed list.
    List<DrugEntity> drugs = new ArrayList<DrugEntity>();
    for(Object object : query.list())
    {
      drugs.add((DrugEntity) object);
    }
    return drugs;
  }



  @Override
  @Transactional(readOnly = true)
  public List<String> getAllNamesAsc()
  {
    Query query = this.sessionFactory.getCurrentSession()
      .createQuery("select D.name from DrugEntity D order by D.name asc");

    // Generate a list of drugs and add this to a typed list.
    List<String> names = new ArrayList<String>();
    for(Object object : query.list())
    {
      names.add((String) object);
    }
    return names;
  }



  @Override
  @Transactional(readOnly = true)
  public long getCount()
  {
    Session session = this.sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(DrugEntity.class);
    criteria.setProjection(Projections.rowCount());
    return (Long) criteria.uniqueResult();
  }
}
