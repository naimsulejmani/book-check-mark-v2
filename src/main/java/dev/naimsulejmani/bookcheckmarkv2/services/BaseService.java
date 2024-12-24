package dev.naimsulejmani.bookcheckmarkv2.services;

import java.util.List;

public interface BaseService<T, TId> {
    List<T> findAll();// findAll(Pageable pageable);

    T findById(TId id);

    T add(T entity);

    T modify(TId id, T entity);

    void deleteById(TId id);
}
