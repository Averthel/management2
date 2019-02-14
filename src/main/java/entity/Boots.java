package entity;

import entity.enums.Color;

public class Boots extends Product {

    private int size;
    private boolean isNatural;

    public Boots(Long id, String productName, double price, double weight, Color color, int productCount, int size, boolean isNatural) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNatural = isNatural;
    }

    public int getSize() {
        return size;
    }

    public boolean isNatural() {
        return isNatural;
    }

    @Override
    public String toString() {
        return "Boots{" +
                "size=" + size +
                ", isNatural=" + isNatural +
                '}';
    }
}
