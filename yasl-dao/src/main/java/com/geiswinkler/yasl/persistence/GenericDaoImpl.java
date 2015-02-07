package com.geiswinkler.yasl.persistence;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.StaleObjectStateException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.FlushModeType;
import javax.persistence.OptimisticLockException;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public abstract class GenericDaoImpl<T extends Serializable, ID extends Serializable> extends HibernateSessionBasedDao<T> implements GenericDao<T, ID> {

    public List<T> findAll() {
        return getEntityManager().createQuery(createCriteriaQueryWithSelection()).getResultList();
    }

    public T findById(ID id) {
        T entity = getEntityManager().find(getPersistentClass(), id);
        return entity;
    }

    public void makeTransient(T entity) {
        getSession().evict(entity);
    }

    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(entity);
    }

    public void refresh(T entity) {
        try {
            getEntityManager().refresh(entity);
        } catch (Throwable e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            if (rootCause != null) {
                if (rootCause instanceof EntityNotFoundException) {
                    throw new OptimisticLockException(rootCause);
                }
            }
            throw e;
        }

    }

    public T merge(T entity) {
        try {
            return getEntityManager().merge(entity);
        } catch (Throwable e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            if (rootCause != null) {
                if (rootCause instanceof OptimisticLockException) {
                    throw (OptimisticLockException) rootCause;
                } else if (rootCause instanceof StaleObjectStateException) {
                    throw new OptimisticLockException(rootCause);
                } else if (rootCause instanceof SQLIntegrityConstraintViolationException) {
                    throw new OptimisticLockException(rootCause);
                }
            }
            throw e;
        }
    }

    public void flush() throws OptimisticLockException {
        try {
            getEntityManager().flush();
        } catch (Throwable e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            if (rootCause != null) {
                if (rootCause instanceof OptimisticLockException) {
                    throw (OptimisticLockException) rootCause;
                } else if (rootCause instanceof StaleObjectStateException) {
                    throw new OptimisticLockException(rootCause);
                } else if (rootCause instanceof SQLIntegrityConstraintViolationException) {
                    throw new OptimisticLockException(rootCause);
                }
            }
            throw e;
        }

    }

    public int getEmDeletgateHash() {
        return getEntityManager().getDelegate().hashCode();
    }

    public FlushModeType getFlushMode() {
        return getEntityManager().getFlushMode();
    }

    @Override
    public void setFlushMode(FlushModeType flushMode) {
        getEntityManager().setFlushMode(flushMode);
    }

    @Override
    public void clearEm() {
        getEntityManager().clear();
    }

    @Override
    public boolean isDirty() {
        return getSession().isDirty();
    }

    public void detach(T entity) {
        getEntityManager().detach(entity);
    }

    public boolean isManaged(T entity) {
        return getEntityManager().contains(entity);
    }
}
