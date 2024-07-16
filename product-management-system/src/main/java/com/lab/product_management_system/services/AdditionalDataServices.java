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

    public List<AdditionalData> getAllData() {
        return additionalDataRepository.findAll();
    }

    public AdditionalData createData(AdditionalData data) {
        return additionalDataRepository.save(data);
    }

    public void deleteData(String id) {
        additionalDataRepository.deleteById(id);
    }
}
