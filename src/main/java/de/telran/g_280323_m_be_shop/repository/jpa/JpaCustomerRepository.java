package de.telran.g_280323_m_be_shop.repository.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.jpa.JpaCustomer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, Integer> {

    @Transactional
    void deleteByName(String name);
}