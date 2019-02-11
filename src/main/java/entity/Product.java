package entity;

public class Product {
    private Long id;
    private String productName;
    private double price;
    private double weight;
    private Color color;
    private int productCount;


    public Product(Long id, String productName, double price, double weight, Color color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color=" + color +
                ", productCount=" + productCount +
                '}';
    }

    public enum Color {
        BLACK("#000000"), WHITE("#FFFFFF"), RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"), YELLOW("#FFFF00");

        private String hex;

        Color(String hex) {
            this.hex = hex;
        }

        public String getHexColor() {
            return hex;
        }
    }
}
