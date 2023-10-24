package application.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private final List<Product> productList = new ArrayList<>();
    int productId = 0;

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product product) {
        product.setId(productId + 1);
        productList.add(product);
    }

    @Override
    public void delete(int productId) {
        productList.removeIf(product -> product.getId() == productId);
    }
}
