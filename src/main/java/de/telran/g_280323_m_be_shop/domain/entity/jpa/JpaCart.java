package de.telran.g_280323_m_be_shop.domain.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Cart;
import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class JpaCart implements Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    private JpaCustomer customer;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<JpaProduct> products;

    public JpaCart() {
    }

    public JpaCart(JpaCustomer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JpaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(JpaCustomer customer) {
        this.customer = customer;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addProduct(Product product) {
        products.add(new JpaProduct(product.getId(), product.getName(), product.getPrice()));
    }

    @Override
    public double getTotalPrice() {
        return products.stream().mapToDouble(JpaProduct::getPrice).sum();
    }

    @Override
    public double getAveragePrice() {
        return products.stream().mapToDouble(JpaProduct::getPrice).average().orElse(0);
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(x -> x.getId() == id);
    }

    @Override
    public void clear() {
        products.clear();
    }

    public void setProducts(List<JpaProduct> products) {
        this.products = products;
    }
}