package com.example.furniturefabrica.repositories;

import com.example.furniturefabrica.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {


}