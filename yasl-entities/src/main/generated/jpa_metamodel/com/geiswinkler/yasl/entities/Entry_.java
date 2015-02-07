package com.geiswinkler.yasl.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Entry.class)
public abstract class Entry_ extends com.geiswinkler.yasl.common.EntityBase_ {

	public static volatile SingularAttribute<Entry, Integer> quantity;
	public static volatile SingularAttribute<Entry, Double> price;
	public static volatile SingularAttribute<Entry, String> name;
	public static volatile SingularAttribute<Entry, Long> id;
	public static volatile SingularAttribute<Entry, ShoppingList> list;

}

