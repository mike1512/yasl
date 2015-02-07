package com.geiswinkler.yasl.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public class TempGenericDaoImpl<T extends Serializable, ID extends Serializable> implements TempGenericDao<T, ID> {
    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public TempGenericDaoImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public T findById( ID id ) {
        return entityManager.find( entityClass, id );
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void persist( T entity ) {
        entityManager.persist( entity );
    }
}
