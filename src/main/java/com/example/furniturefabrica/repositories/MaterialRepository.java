package com.example.furniturefabrica.repositories;

import com.example.furniturefabrica.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material,Integer> {
}
