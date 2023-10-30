package de.telran.g_280323_m_be_shop.domain.entity.interfaces;

import java.util.List;

public interface Cart {

    List<Product> getProducts();

    void addProduct(Product product);

    double getTotalPrice();

    double getAveragePrice();

    void deleteProduct(int id);

    void clear();
}