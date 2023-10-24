package application.repository;

import java.util.List;
public interface IRepository<E> {
    E getById(int id);
    List<E> getAll();
    void add(E e);
    void delete(int id);
}
