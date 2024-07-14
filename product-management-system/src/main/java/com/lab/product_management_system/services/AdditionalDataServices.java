package com.lab.product_management_system.services;

import com.lab.product_management_system.model.AdditionalData;
import com.lab.product_management_system.repository.AdditionalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalDataServices {

    @Autowired
    private AdditionalDataRepository additionalDataRepository;

    public List<AdditionalData> getAllAdditionalData() {
        return additionalDataRepository.findAll();
    }

    public AdditionalData getAdditionalDataByProductId(String id) {
        return additionalDataRepository.findById(id).orElse(null);
    }

    public AdditionalData createAdditionalData(AdditionalData additionalData) {
        return additionalDataRepository.save(additionalData);
    }

    public AdditionalData updateAdditionalData(String id, AdditionalData additionalData) {
        additionalData.setId(id);
        return additionalDataRepository.save(additionalData);
    }

    public void deleteAdditionalData(String id) {
        additionalDataRepository.deleteById(id);
    }
}

