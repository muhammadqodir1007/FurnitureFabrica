package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.RawMaterialOutPut;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.repositories.RawMaterialOutPutRepository;
import com.sun.tools.javac.util.DefinedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialOutPutService {

    @Autowired
    RawMaterialOutPutRepository rawMaterialOutPutRepository;


    public ApiResponse add(RawMaterialOutPut rawMaterialOutPut) {

        RawMaterialOutPut rawMaterialOutPut1 = new RawMaterialOutPut();
        rawMaterialOutPut1.setAmount(rawMaterialOutPut.getAmount());
        rawMaterialOutPut1.setComment(rawMaterialOutPut.getComment());
        rawMaterialOutPut1.setDate(rawMaterialOutPut.getDate());
        rawMaterialOutPut1.setName(rawMaterialOutPut.getName());
        rawMaterialOutPutRepository.save(rawMaterialOutPut1);

        return new ApiResponse("success", true);


    }

    public ApiResponse edit(Integer id, RawMaterialOutPut rawMaterialOutPut) {

        Optional<RawMaterialOutPut> byId = rawMaterialOutPutRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);

        RawMaterialOutPut rawMaterialOutPut1 = byId.get();
        rawMaterialOutPut1.setAmount(rawMaterialOutPut.getAmount());
        rawMaterialOutPut1.setComment(rawMaterialOutPut.getComment());
        rawMaterialOutPut1.setDate(rawMaterialOutPut.getDate());
        rawMaterialOutPut1.setName(rawMaterialOutPut.getName());
        rawMaterialOutPutRepository.save(rawMaterialOutPut1);

        return new ApiResponse("success", true);


    }

    public List<RawMaterialOutPut> get() {
        return rawMaterialOutPutRepository.findAll();

    }

    public ApiResponse getOne(Integer id) {
        Optional<RawMaterialOutPut> byId = rawMaterialOutPutRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("nor found", false);

        RawMaterialOutPut rawMaterialOutPut = byId.get();


        return new ApiResponse("success", true, rawMaterialOutPut);


    }

    public ApiResponse delete(Integer id) {
        Optional<RawMaterialOutPut> byId = rawMaterialOutPutRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);

        rawMaterialOutPutRepository.deleteById(id);


        return new ApiResponse("success", true);

    }

}
