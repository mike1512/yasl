package com.geiswinkler.yasl.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public interface TempGenericDao<T extends Serializable, ID extends Serializable> {

    T findById(ID id);

    List<T> findAll();

    void persist(T entity);
}
