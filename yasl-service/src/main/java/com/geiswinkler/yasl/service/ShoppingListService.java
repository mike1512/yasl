package com.geiswinkler.yasl.service;

import com.geiswinkler.yasl.entities.ShoppingList;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mike on 06.02.2015.
 */
public interface ShoppingListService {
    public List<ShoppingList> getAll();

    public void save(ShoppingList shoppingList);

    public ShoppingList getById(Long id);
}
