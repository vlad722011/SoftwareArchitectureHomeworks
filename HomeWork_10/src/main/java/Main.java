import application.dao.IProductDao;
import application.dao.Product;
import application.dao.ProductDao;
import application.repository.IRepository;
import application.repository.ProductRepository;
import application.serviceLayer.ProductService;
import application.unitOfWork.UnitOfWork;

public class Main {
    public static void main(String[] args) {

        IProductDao productDao = new ProductDao();
        IRepository <Product> iRepository = new ProductRepository(productDao);
        ProductService productService = new ProductService(iRepository);
        UnitOfWork unitOfWork = new UnitOfWork(productService);


        System.out.println("Есть поступление следующих товаров:");


        Product one = new Product ( 1, "Redmi A2 plus, 3+64 Гб", 6990);
        System.out.println(one);
        Product two = new Product ( 2, "Redmi Note 12, 8+256 Гб", 21990);
        System.out.println(two);
        Product three = new Product ( 3, "Redmi Note 12, 4+128 Гб", 17490);
        System.out.println(three);
        Product four = new Product ( 4, "Redmi Note 12S, 8+256 Гб", 22990);
        System.out.println(four);
        Product five = new Product ( 5, "Redmi Note 12 Pro Plus 5G, 8+256 Гб", 39990);
        System.out.println(five);


        //база недорогих смартфонов (цена не дороже 20 тысяч):
        System.out.print("Товаров в базе недорогих смартфонов (цена менее 20 тысяч) сейчас: ");
        System.out.println(iRepository.getAll().size());


        //добавим товаров в базу:
        unitOfWork.addProduct(one);
        System.out.println("Начинаем транзакцию по добвалению не дорогих смартфонов в базу данных.");
        System.out.println("Добавили первый товар.");
        unitOfWork.addProduct(two);
        System.out.println("Добавили  второй товар.");
        unitOfWork.addProduct(three);
        System.out.println("Добавили третий товар.");
        unitOfWork.addProduct(four);
        System.out.println("Добавили четвертый товар.");
        unitOfWork.addProduct(five);
        System.out.println("Добавили пятый товар.");

        //revert all operations
        System.out.println("Решили откатить транзакцию, и не стали добавлять товары в базу данных.");
        unitOfWork.revertTranzaction();

        //база недорогих смартфонов (цена не дороже 20 тысяч):
        System.out.print("Товаров в базе недорогих смартфонов (цена менее 20 тысяч) сейчас: ");
        System.out.println(iRepository.getAll().size());


        //добавим товаров в базу:
        unitOfWork.addProduct(one);
        System.out.println("Начинаем транзакцию по добавлению не дорогих смартфонов в базу данных.");
        System.out.println("Добавили первый товар.");
        unitOfWork.addProduct(two);
        System.out.println("Добавили  второй товар.");
        unitOfWork.addProduct(three);
        System.out.println("Добавили третий товар.");
        unitOfWork.addProduct(four);
        System.out.println("Добавили четвертый товар.");
        unitOfWork.addProduct(five);
        System.out.println("Добавили пятый товар.");

        //commit (подтверждение транзакции)
        System.out.println("Завершаем транзакцию, и добавляем товары в базу данных.");
        unitOfWork.commit();

        //база недорогих смартфонов (цена не дороже 20 тысяч):
        System.out.print("Товаров в базе недорогих смартфонов (цена менее 20 тысяч) сейчас: ");
        System.out.println(iRepository.getAll().size());
    }
}
