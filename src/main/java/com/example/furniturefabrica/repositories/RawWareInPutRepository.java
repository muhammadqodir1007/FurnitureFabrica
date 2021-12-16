package com.example.furniturefabrica.repositories;

import com.example.furniturefabrica.entity.RawWareHouseInput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawWareInPutRepository extends JpaRepository<RawWareHouseInput,Integer> {
}
