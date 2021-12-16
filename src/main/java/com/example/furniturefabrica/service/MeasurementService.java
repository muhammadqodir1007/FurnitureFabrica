package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Measurement;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.MeasurementDto;
import com.example.furniturefabrica.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;


    public ApiResponse addMeasurement(Measurement measurement) {

        Measurement measurement1 = new Measurement();
        measurement1.setNameRu(measurement.getNameRu());
        measurement1.setNameUz(measurement.getNameUz());
        measurementRepository.save(measurement1);
        return new ApiResponse("saved", true);


    }

    public List<Measurement> getAll() {
        return measurementRepository.findAll();


    }

    public ApiResponse getOne(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("measurement not found", false);
        Measurement measurement = byId.get();
        return new ApiResponse("success", true, measurement);


    }

    public ApiResponse edit(Integer id, Measurement measurement1) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("measurement not found", false);
        Measurement measurement = byId.get();
        measurement.setNameUz(measurement1.getNameUz());
        measurement.setNameRu((measurement1.getNameRu()));
        measurementRepository.save(measurement);


        return new ApiResponse("edited", true);

    }

    public ApiResponse delete(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("measurement not found", false);
        measurementRepository.deleteById(id);
        return new ApiResponse("deleted",true);


    }


}
