package com.geiswinkler.yasl.service;

import java.io.Serializable;

import com.geiswinkler.yasl.dao.ShoppingListDao;
import com.geiswinkler.yasl.entities.ShoppingList;
import com.geiswinkler.yasl.service.ShoppingListService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mike on 05.02.2015.
 */
public class ShoppingListServiceImpl implements ShoppingListService, Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    ShoppingListDao shoppingListDao;

    @Override
    public List<ShoppingList> getAll() {
        return shoppingListDao.findAll();
    }

    @Override
    public void save(ShoppingList shoppingList) {
        shoppingListDao.persist(shoppingList);
    }

    @Override
    public ShoppingList getById(Long id) {
        return shoppingListDao.findById(id);
    }
}
