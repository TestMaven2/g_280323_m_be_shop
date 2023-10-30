package de.telran.g_280323_m_be_shop.repository.interfaces;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();

    Customer getById(int id);

    void add(String name);

    void delete(int id);

    void addToCartById(int customerId, int productId);

    void deleteFromCartById(int customerId, int productId);

    void clearCart(int customerId);
}