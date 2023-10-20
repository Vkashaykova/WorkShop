package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.Objects;

public class Category {

    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 15;

    private String name;
    private ArrayList<Product> products;


    public Category(String name) {
        setName(name);
        products = new ArrayList<>();

    }

    public String getName() {

        return name;
    }

    private void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Name should be between 2 and 15 symbols.");
        }
            this.name = name;

    }
    public ArrayList<Product> getProducts() {

        return new ArrayList<>(products);

    }

    public void addProduct(Product product) {
         products.add(product);
         }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            this.products.remove(product);
        } else {
            throw new IllegalArgumentException("Product not found in category.");
        }
    }


//    public String print() {
//        StringBuilder result = new StringBuilder();
//        result.append(String.format("#Category: %s\n",name));
//        if (products.isEmpty()){
//            result.append(" #No product in this category");
//        } else {
//            for (Product product: products) {
//                result.append(product.print());
//            }
//        }
//        return result.toString();
//    }

    public String print() {
        if (products.isEmpty()) {
            return String.format("#Category: %s%n" +
                    " #No product in this category", this.name);
        } else {
            return String.format("#Category: %s%n" +
                    " #%s %s%n" +
                    " #Price: %.2f%n" +
                    " #Gender: %s%n" +
                    " ===" , this.name, products.get(0), products.get(1), products.get(2), products.get(3));
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(products, category.products);
    }


}
