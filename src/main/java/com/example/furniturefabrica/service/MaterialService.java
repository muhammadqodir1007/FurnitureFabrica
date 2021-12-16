package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Attachment;
import com.example.furniturefabrica.entity.Material;
import com.example.furniturefabrica.entity.Measurement;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.MaterialDto;
import com.example.furniturefabrica.repositories.AttachmentRepository;
import com.example.furniturefabrica.repositories.MaterialRepository;
import com.example.furniturefabrica.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;


    public List<Material> getMaterials() {

        return materialRepository.findAll();


    }

    public ApiResponse addMaterial(MaterialDto materialDto) {

        Material material = new Material();

        material.setNameRu(material.getNameRu());
        material.setNameUz(material.getNameUz());
        material.setCode(material.getCode());
        material.setNormal(material.getNormal());
        Attachment attachment = new Attachment();
        Optional<Attachment> byId = attachmentRepository.findById(materialDto.getAttachmentId());
        if (!byId.isPresent()) return new ApiResponse("photo not found", false);
        material.setAttachment(byId.get());
        Optional<Measurement> byId1 = measurementRepository.findById(materialDto.getMeasurementId());
        if (!byId1.isPresent()) return new ApiResponse("measurement not found", false);
        Measurement measurement = byId1.get();
        material.setMeasurement(measurement);

        return new ApiResponse("success", true);


    }

    public ApiResponse editMaterial(Integer id, MaterialDto materialDto) {
        Optional<Material> byId = materialRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);

        Material material = byId.get();
        material.setNormal(materialDto.getNormal());
        material.setCode(material.getCode());
        material.setNameUz(material.getNameUz());
        material.setNameRu(materialDto.getNameRu());
        Optional<Measurement> byId1 = measurementRepository.findById(id);
        if (!byId1.isPresent()) return new ApiResponse("measurement not found", false);
        Measurement measurement = byId1.get();
        material.setMeasurement(measurement);

        materialRepository.save(material);
        return new ApiResponse("edited", true);


    }

    public List<Material> getAll() {
        return materialRepository.findAll();


    }

    public ApiResponse findOne(Integer id) {
        Optional<Material> byId = materialRepository.findById(id);
        if (byId.isPresent()) return new ApiResponse("material not found", false);
        Material material = byId.get();
        return new ApiResponse("success", true, material);

    }

    public ApiResponse deleteById(Integer id) {
        Optional<Material> byId = materialRepository.findById(id);
        if (byId.isPresent()) return new ApiResponse("material not found", false);
        materialRepository.deleteById(id);

        return new ApiResponse("deleted", true);


    }
}
