package application.unitOfWork;

import application.dao.Product;
import application.serviceLayer.ProductService;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final List<Product> newProducts = new ArrayList<>();
    private final List<Product> deletedProducts = new ArrayList<>();
    private final ProductService productService;

    public UnitOfWork(ProductService productService) {
        this.productService = productService;
    }
    public void addProduct(Product product) {
        newProducts.add(product);
    }

    public void deleteProduct(Product product) {
        deletedProducts.add(product);
    }

    public void commit()  {
        for (Product product : newProducts) {
            productService.addInexpensiveProducts(product);
        }
        for (Product product : deletedProducts) {
            productService.deleteInexpensiveProducts(product.getId());
        }
        newProducts.clear();
        deletedProducts.clear();
    }
    public void revertTranzaction() {
        newProducts.clear();
        deletedProducts.clear();
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
