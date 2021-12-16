package com.example.furniturefabrica.repositories;

import com.example.furniturefabrica.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
