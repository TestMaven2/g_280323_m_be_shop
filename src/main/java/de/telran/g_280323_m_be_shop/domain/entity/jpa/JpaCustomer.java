package de.telran.g_280323_m_be_shop.domain.entity.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private JpaCart cart;

    public JpaCustomer() {
    }

    public JpaCustomer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JpaCart getCart() {
        return cart;
    }

    public void setCart(JpaCart cart) {
        this.cart = cart;
    }
}