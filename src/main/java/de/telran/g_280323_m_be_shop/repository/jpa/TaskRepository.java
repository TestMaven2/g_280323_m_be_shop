package de.telran.g_280323_m_be_shop.repository.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}