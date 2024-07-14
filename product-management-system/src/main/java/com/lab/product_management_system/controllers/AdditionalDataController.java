package com.lab.product_management_system.controllers;

import com.lab.product_management_system.model.AdditionalData;
import com.lab.product_management_system.services.AdditionalDataServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/additional-data")
public class AdditionalDataController {

    private final AdditionalDataServices additionalDataService;

    public AdditionalDataController(AdditionalDataServices additionalDataService) {
        this.additionalDataService = additionalDataService;
    }

//    @GetMapping("/product/{productId}")
//    public ResponseEntity<List<AdditionalData>> getAdditionalDataByProductId(@PathVariable Long productId) {
//        List<AdditionalData> additionalData = additionalDataService.getAdditionalDataByProductId(productId);
//        return new ResponseEntity<>(additionalData, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<AdditionalData> createAdditionalData(@RequestBody AdditionalData additionalData) {
        AdditionalData createdData = additionalDataService.createAdditionalData(additionalData);
        return new ResponseEntity<>(createdData, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdditionalData(@PathVariable String id) {
        additionalDataService.deleteAdditionalData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

