package com.geiswinkler.yasl.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ShoppingList.class)
public abstract class ShoppingList_ extends com.geiswinkler.yasl.common.EntityBase_ {

	public static volatile ListAttribute<ShoppingList, Entry> entries;
	public static volatile SingularAttribute<ShoppingList, String> name;
	public static volatile SingularAttribute<ShoppingList, Long> id;
	public static volatile SingularAttribute<ShoppingList, ShoppingListStatus> status;

}

