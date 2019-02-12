import api.ProductService;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;
import service.ProductServiceImpl;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0, 0.3,   Product.Color.BLACK, 4, 38, true));

        ProductServiceImpl productsService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productsService.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);

    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0, 0.3,   Product.Color.BLACK, 4, 38, true));


        ProductServiceImpl productsService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3l, "Spodnie", 44., 0., Product.Color.WHITE, 3, "S", "COTTON"));
        List<Product> productsFromTestClass = productsService.getAllProducts();


        Assert.assertNotEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetProductCount() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0, 0.3,   Product.Color.BLACK, 4, 38, true));

        ProductServiceImpl productsService = new ProductServiceImpl(products);
        final int result = productsService.getProductCount();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetProductCountNegative() {
        ProductServiceImpl productsService = new ProductServiceImpl();

        final int result = productsService.getProductCount();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByNameIfExist(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, Product.Color.BLACK, 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByNameIfExist("T-SHIRT");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByNameNoExist(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, Product.Color.BLACK, 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByNameIfExist("nieistniejacyProdukt");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWareHouseWhenIs(){
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0, 0.3, Product.Color.BLACK, 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean productOnWareHouse = productService.isProductOnWarehouse("Boots");

        Assert.assertTrue(productOnWareHouse);

    }

    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Fake");

        Assert.assertFalse(isProductOnWareHouse);
    }

    @Test
    public  void testIsProductExistByNameWhenExist(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistByName = productService.isProductExistByName("Boots");

        Assert.assertTrue(isProductExistByName);
    }

    @Test
    public  void testIsProductExistByNameWhenNoExist(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistByName = productService.isProductExistByName("Fake");

        Assert.assertFalse(isProductExistByName);
    }

    @Test
    public void tesIsProductExistById(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistById = productService.isProductExistById(2l);

        Assert.assertTrue(isProductExistById);

    }

    @Test
    public void tesIsProductExistByIdF(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0, 0.3, Product.Color.BLACK, 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExistById = productService.isProductExistById(5l);

        Assert.assertFalse(isProductExistById);

    }
}
