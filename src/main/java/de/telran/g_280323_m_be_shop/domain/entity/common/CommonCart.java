package de.telran.g_280323_m_be_shop.domain.entity.common;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Cart;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;

import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart {

    private List<Product> products = new ArrayList<>();

    public CommonCart() {
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public double getTotalPrice() {
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public double getAveragePrice() {
        if (products.isEmpty()) {
            return 0;
        }
        return getTotalPrice() / products.size();
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(x -> x.getId() == id);
    }

    @Override
    public void clear() {
        products.clear();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}