package com.geiswinkler.yasl.persistence;

import javax.persistence.FlushModeType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public interface GenericDao<T extends Serializable, ID extends Serializable> {

    T findById( ID id );

    List<T> findAll();

    SearchResultList<T> findByFilter( CriteriaQueryTransformable<T> filter );

    void persist( T entity );

    void remove( T entity );

    void makeTransient( T entity );

    void refresh( T entity );

    T merge( T entity );

    void flush();

    FlushModeType getFlushMode();

    boolean isDirty();

    void detach( T entity );

    boolean isManaged( T entitiy );

    void clearEm();

    void setFlushMode( FlushModeType flushMode );
}
