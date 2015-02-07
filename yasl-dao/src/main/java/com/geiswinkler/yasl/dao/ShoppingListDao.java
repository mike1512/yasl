package com.geiswinkler.yasl.dao;

import com.geiswinkler.yasl.entities.ShoppingList;
import com.geiswinkler.yasl.persistence.CriteriaQueryTransformable;
import com.geiswinkler.yasl.persistence.GenericDao;
import com.geiswinkler.yasl.persistence.SearchResultList;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public interface ShoppingListDao extends GenericDao<ShoppingList, Long> {
    @Override
    ShoppingList findById(Long aLong);

    @Override
    List<ShoppingList> findAll();

    @Override
    SearchResultList<ShoppingList> findByFilter(CriteriaQueryTransformable<ShoppingList> filter);

    @Override
    void persist(ShoppingList entity);

    @Override
    void remove(ShoppingList entity);

    @Override
    void makeTransient(ShoppingList entity);

    @Override
    void refresh(ShoppingList entity);

    @Override
    ShoppingList merge(ShoppingList entity);

    @Override
    void flush();

    @Override
    FlushModeType getFlushMode();

    @Override
    boolean isDirty();

    @Override
    void detach(ShoppingList entity);

    @Override
    boolean isManaged(ShoppingList entitiy);

    @Override
    void clearEm();

    @Override
    void setFlushMode(FlushModeType flushMode);
}
