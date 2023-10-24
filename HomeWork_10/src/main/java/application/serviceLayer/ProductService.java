package application.serviceLayer;


import application.dao.Product;
import application.repository.IRepository;

import java.util.List;

public class ProductService {


    private final IRepository<Product> productIRepository;


    public ProductService(IRepository<Product> productIRepository) {
        this.productIRepository = productIRepository;
    }

    public void addInexpensiveProducts(Product product) {
        int productId = product.getId();
        double price = product.getPrice();
        if (price < 20000.00) {
            productIRepository.add(product);
        }
        else if (price > 20000.00){
            System.out.println("Недопустимая цена");
        }
    }

    public void deleteInexpensiveProducts(int id) {
        if (productIRepository.getById(id).getPrice() < 20000.00) {
            productIRepository.delete(id);
        }
        else if (productIRepository.getById(id).getPrice() > 20000.00) {
            System.out.println("Недопустимая цена");
        }
    }

    public List<Product> getAllProducts() {
        return productIRepository.getAll();
    }


}
