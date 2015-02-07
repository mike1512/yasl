package com.geiswinkler.yasl.persistence;

import java.io.Serializable;
import java.util.List;

public interface SearchResultList<T extends Serializable> extends List<T> {

	int getSearchLimit();

	boolean isSearchLimitExceeded();

	int getOrginalSize();
}
