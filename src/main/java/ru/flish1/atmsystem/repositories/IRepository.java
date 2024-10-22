package ru.flish1.atmsystem.repositories;

public interface IRepository<T, V> {

    T save(T entity);

    T update(T entity);

    void remove(T entity);

    T findById(V id);
}
