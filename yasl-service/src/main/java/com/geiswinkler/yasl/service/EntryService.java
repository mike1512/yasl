package com.geiswinkler.yasl.service;

import com.geiswinkler.yasl.dao.EntryDao;
import com.geiswinkler.yasl.entities.Entry;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Service class for Entity Entry
 * Created by mike on 05.02.2015.
 */
public interface EntryService extends Serializable {
    public void save(Entry entry);
    public Entry getById(int id);
}
