package com.geiswinkler.yasl.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SearchResultListImpl<T extends Serializable> implements SearchResultList<T> {

    private List<T> delegate;

    private int searchLimit;

    private boolean searchLimitExceeded;

    private int orinalSize;

    public SearchResultListImpl( List<T> result, int searchLimit, int orginalSize, boolean searchLimitExceeded ) {
        this.searchLimitExceeded = searchLimitExceeded;
        if (result.size() > searchLimit) {
            this.orinalSize = result.size();
            this.delegate = result.subList(0, searchLimit);
        } else {
            this.delegate = result;
        }

        this.orinalSize = orginalSize;
        this.searchLimit = searchLimit;
    }

    public SearchResultListImpl( List<T> result, int searchLimit, int orginalSize ) {
        this.searchLimitExceeded = result.size() > searchLimit;
        if (searchLimitExceeded) {
            this.delegate = result.subList(0, searchLimit);
        } else {
            this.delegate = result;
        }
        this.searchLimit = searchLimit;
        this.orinalSize = orginalSize;
    }

    public SearchResultListImpl( List<T> result ) {
        this(result, result.size(), result.size());
    }

    public int getSearchLimit() {
        return searchLimit;
    }

    public boolean isSearchLimitExceeded() {
        return searchLimitExceeded;
    }

    public int getOrginalSize() {
        return orinalSize;
    }

    public static <T extends Serializable> SearchResultListImpl<T> emptyList(Class<T> clazz) {
        return new SearchResultListImpl(Collections.emptyList(), 0, 0, false);
    }

    public boolean add(T o) {
        return delegate.add(o);
    }

    public void add(int index, T element) {
        delegate.add(index, element);
    }

    public boolean addAll(Collection<? extends T> c) {
        return delegate.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return delegate.addAll(index, c);
    }

    public void clear() {
        delegate.clear();
    }

    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return delegate.containsAll(c);
    }

    public T get(int index) {
        return delegate.get(index);
    }

    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    public ListIterator<T> listIterator() {
        return delegate.listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return delegate.listIterator(index);
    }

    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    public T remove(int index) {
        return delegate.remove(index);
    }

    public boolean removeAll(Collection<?> c) {
        return delegate.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return delegate.retainAll(c);
    }

    public T set(int index, T element) {
        return delegate.set(index, element);
    }

    public int size() {
        return delegate.size();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }

    public Object[] toArray() {
        return delegate.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return delegate.toArray(a);
    }
}
