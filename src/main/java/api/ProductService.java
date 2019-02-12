package api;

import entity.Product;

import java.util.List;

public interface ProductService {



    List<Product> getAllProducts();

    Integer getProductCount();

    Product getProductByNameIfExist(String productName);

    boolean isProductOnWarehouse(String productName);

    boolean isProductExistByName(String productName);

    boolean isProductExistById(Long productId);



}
