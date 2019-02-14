package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getProductCount() {
        return products.size();
    }

    public Product getProductByNameIfExist(String productName) {
        for (Product szukany : products) {
            if (szukany.getProductName().equals(productName)) {
                return szukany;
            }
        }
        return null;
    }

    public boolean isProductOnWarehouse(String productName) {
        for (Product szukany : products) {
            if (isProductExistByName(productName) && getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductExistByName(String productName) {
        for (Product szukany : products) {
            if (szukany.getProductName().equals(productName)) {
                return true;


            }
        }
        return false;
    }

    public boolean isProductExistById(Long productId) {
        for (Product szukany : products) {
            if (szukany.getId().equals(productId)) {
                return true;
            }
        }
        return false;
    }
}
