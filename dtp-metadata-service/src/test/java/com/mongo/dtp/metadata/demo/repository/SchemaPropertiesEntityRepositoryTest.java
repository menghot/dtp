package com.mongo.dtp.metadata.demo.repository;

import com.mongo.dtp.metadata.model.SchemaPropertiesEntity;
import com.mongo.dtp.metadata.repository.SchemaPropertiesEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SchemaPropertiesEntityRepositoryTest
{

    @Autowired
    private SchemaPropertiesEntityRepository schemaPropertiesEntityRepository;

    @Test
    @DirtiesContext
    public void testSaveSchemaProperties()
    {
        SchemaPropertiesEntity schemaPropertiesEntity = new SchemaPropertiesEntity();
        schemaPropertiesEntity.setCatalog("Test Catalog");
        schemaPropertiesEntity.setSchema("Test Schema");
        schemaPropertiesEntity.setPropertyName("Test Property");
        schemaPropertiesEntity.setPropertyValue("Test Value");

        SchemaPropertiesEntity savedSchemaPropertiesEntity = schemaPropertiesEntityRepository.save(schemaPropertiesEntity);

        assertNotNull(savedSchemaPropertiesEntity);
        assertEquals("Test Catalog", savedSchemaPropertiesEntity.getCatalog());
        assertEquals("Test Schema", savedSchemaPropertiesEntity.getSchema());
        assertEquals("Test Property", savedSchemaPropertiesEntity.getPropertyName());
    }

    // Add more tests as needed
}
