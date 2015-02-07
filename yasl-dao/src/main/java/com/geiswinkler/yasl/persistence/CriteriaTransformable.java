package com.geiswinkler.yasl.persistence;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;

/**
 * Interface for custom filters to transform them into an Hibernate Criteria.
 * 
 * @author Stephan Bluemel
 * 
 * @param <T>
 *            Type of the entity the filter stands for.
 */
public interface CriteriaTransformable<T extends Serializable> {

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
	 * @param entityName
	 *            Name of the entity in the HQL expression
	 * 
	 * @return the filled criteria
	 */
	public DetachedCriteria toCriteria(DetachedCriteria c, String entityName, boolean includeOrderBy);

	public boolean isEmpty();
}
