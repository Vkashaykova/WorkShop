package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {

        products=new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        } else
            throw new IllegalArgumentException(String.format("Shopping cart does not contain product with name %s!.",product));
        }

    
    public boolean containsProduct(Product product) {
        boolean isFound=false;

        if(products.contains(product)){
            return true;
        }
        return isFound;

    }
    
    public double totalPrice() {
        double totalPrice=0.00;
        for (Product product : products) {
            totalPrice+=product.getPrice();

        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products);
    }


}
