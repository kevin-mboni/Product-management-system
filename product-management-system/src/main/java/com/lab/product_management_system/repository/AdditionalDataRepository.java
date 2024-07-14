package com.lab.product_management_system.repository;

import com.lab.product_management_system.model.AdditionalData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDataRepository extends MongoRepository<AdditionalData, String> {
}
