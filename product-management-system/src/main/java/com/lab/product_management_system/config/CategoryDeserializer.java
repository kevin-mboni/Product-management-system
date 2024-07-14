package com.lab.product_management_system.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.lab.product_management_system.model.Category;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {

    @Override
    public Category deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String categoryName = jsonParser.getText();
        return new Category(categoryName);
    }
}
