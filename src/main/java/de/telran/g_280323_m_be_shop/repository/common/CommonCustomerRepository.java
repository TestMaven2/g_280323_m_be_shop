package de.telran.g_280323_m_be_shop.repository.common;

import de.telran.g_280323_m_be_shop.domain.database.common.CommonDatabase;
import de.telran.g_280323_m_be_shop.domain.database.interfaces.Database;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import de.telran.g_280323_m_be_shop.repository.interfaces.CustomerRepository;
import de.telran.g_280323_m_be_shop.repository.interfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class CommonCustomerRepository implements CustomerRepository {

    @Autowired
    private Database database;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Customer> getAll() {
        try {
            List<Object> objects = database.select("Select all customers");
            return objects.stream().map(x -> (Customer) x).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(int id) {
        try {
            return (Customer) database.select("Select customer where id = " + id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name) {
        try {
            database.execute("Add new customer name = " + name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            database.execute("Delete customer where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        Customer customer = getById(customerId);
        Product product = productRepository.getById(productId);
        customer.getCart().addProduct(product);
    }

    @Override
    public void deleteFromCartById(int customerId, int productId) {
        Customer customer = getById(customerId);
        customer.getCart().deleteProduct(productId);
    }

    @Override
    public void clearCart(int customerId) {
        Customer customer = getById(customerId);
        customer.getCart().clear();
    }
}