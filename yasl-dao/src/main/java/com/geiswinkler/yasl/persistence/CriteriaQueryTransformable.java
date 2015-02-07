package com.geiswinkler.yasl.persistence;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface CriteriaQueryTransformable<T extends Serializable> {
	/**
	 * Fills the given (non null) criteria with the criterions defined through
	 * the filter and returns it.
	 * 
	 * The caller of the CriteriaTransformable instance should set the name
	 * under which the entity for this filter is available in the criteria query.
	 * 
	 * If nothing is set the name is null and the method should use "this".
	 * 
	 * @param c
	 *            the criteria to fill
	 * 
	 * 
	 * @return the filled criteria
	 */
	public Predicate toCriteria(Root<T> root, CriteriaBuilder builder, boolean includeOrderBy);

	public boolean isEmpty();

	public Order[] getOrder(Root<T> root, CriteriaBuilder builder);

	public Integer getMaxResult();
}
