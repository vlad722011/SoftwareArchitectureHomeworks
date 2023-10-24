package application.repository;

import application.dao.Product;
import application.dao.IProductDao;

import java.util.List;

public class ProductRepository  implements IRepository<Product>{

    private final IProductDao productDao;

    public ProductRepository(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }
}
