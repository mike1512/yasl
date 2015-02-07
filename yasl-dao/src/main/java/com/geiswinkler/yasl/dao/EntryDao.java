package com.geiswinkler.yasl.dao;

import com.geiswinkler.yasl.entities.Entry;
import com.geiswinkler.yasl.persistence.CriteriaQueryTransformable;
import com.geiswinkler.yasl.persistence.GenericDao;
import com.geiswinkler.yasl.persistence.SearchResultList;

import javax.persistence.FlushModeType;
import java.util.List;


/**
 * Data Access Object for Entity - Entry
 *
 * Created by mike on 05.02.2015.
 */
public interface EntryDao extends GenericDao<Entry, Long> {
    @Override
    Entry findById(Long aLong);

    @Override
    List<Entry> findAll();

    @Override
    SearchResultList<Entry> findByFilter(CriteriaQueryTransformable<Entry> filter);

    @Override
    void persist(Entry entity);

    @Override
    void remove(Entry entity);

    @Override
    void makeTransient(Entry entity);

    @Override
    void refresh(Entry entity);

    @Override
    Entry merge(Entry entity);

    @Override
    void flush();

    @Override
    FlushModeType getFlushMode();

    @Override
    boolean isDirty();

    @Override
    void detach(Entry entity);

    @Override
    boolean isManaged(Entry entitiy);

    @Override
    void clearEm();

    @Override
    void setFlushMode(FlushModeType flushMode);
}
