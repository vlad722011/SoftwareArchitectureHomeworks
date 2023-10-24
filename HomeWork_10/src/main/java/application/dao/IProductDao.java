package application.dao;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();
    Product findById(int id);
    void add(Product product);
    void delete(int id);
}
