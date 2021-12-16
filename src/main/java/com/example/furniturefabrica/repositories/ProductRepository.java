package com.example.furniturefabrica.repositories;

import com.example.furniturefabrica.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
