package com.geiswinkler.yasl.persistence;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by mike on 06.02.2015.
 */
public class HibernateSessionBasedDao<T extends Serializable> {

    private static final int DEFAULT_MAX_SEARCH_RESULT = 100;

    private static final String MAX_SEARCH_RESULT_KEY = "searchResult.max";

    protected int maxSearchResult = DEFAULT_MAX_SEARCH_RESULT;

    @PersistenceContext
    protected EntityManager em;

    private Class<T> persistentClass;

    public HibernateSessionBasedDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.maxSearchResult = 100000; // Conf.getConfig().getInt(MAX_SEARCH_RESULT_KEY, DEFAULT_MAX_SEARCH_RESULT);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    protected Session getSession() {
        return (Session) getEntityManager().getDelegate();
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        }
        return em;
    }

    public SearchResultList<T> findByFilter(CriteriaQueryTransformable<T> filter) {
        CriteriaQuery<T> cq = createCriteriaQuery();
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        Root<T> root = cq.from(getPersistentClass());
        Predicate predicate = filter.toCriteria(root, builder, false);
        cq.where(predicate);

        javax.persistence.criteria.Order[] order = filter.getOrder(root, builder);
        if (order != null && order.length > 0) {
            cq.orderBy(order);
        }

        if (filter.getMaxResult() == null) {
            return queryToSearchResultList(cq);
        } else {
            return queryToSearchResultList(cq, filter.getMaxResult());
        }

    }

    protected SearchResultList<T> queryToSearchResultList(CriteriaQuery<T> crit) {
        TypedQuery<T> typedQuery = getEntityManager().createQuery(crit);
        typedQuery.setMaxResults(maxSearchResult + 1);
        int count = 0;
        return new SearchResultListImpl<T>(typedQuery.getResultList(), maxSearchResult, count);
    }

    protected SearchResultList<T> queryToSearchResultList(CriteriaQuery<T> crit, Integer maxResult) {
        TypedQuery<T> typedQuery = getEntityManager().createQuery(crit);
        typedQuery.setMaxResults(maxResult + 1);
        int count = 0;
        return new SearchResultListImpl<T>(typedQuery.getResultList(), maxResult, count);
    }

    protected CriteriaQuery<T> createCriteriaQuery() {
        return getEntityManager().getCriteriaBuilder().createQuery(getPersistentClass());
    }

    protected CriteriaQuery<T> createCriteriaQueryWithSelection() {
        CriteriaQuery<T> cq = createCriteriaQuery();
        Root<T> root = cq.from(getPersistentClass());
        cq.select(root);
        return cq;
    }
}