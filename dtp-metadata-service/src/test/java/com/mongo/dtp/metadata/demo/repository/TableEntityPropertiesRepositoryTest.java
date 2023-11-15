package com.mongo.dtp.metadata.demo.repository;

import com.mongo.dtp.metadata.model.TablePropertiesEntity;
import com.mongo.dtp.metadata.repository.TablePropertiesEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TableEntityPropertiesRepositoryTest
{

    @Autowired
    private TablePropertiesEntityRepository tablePropertiesEntityRepository;

    @Test
    @DirtiesContext
    public void testSaveTableProperties()
    {
        TablePropertiesEntity tablePropertiesEntity = new TablePropertiesEntity();
        tablePropertiesEntity.setCatalog("Test Catalog");
        tablePropertiesEntity.setSchema("Test Schema");
        tablePropertiesEntity.setTable("Test Table");
        tablePropertiesEntity.setPropertyName("Test Property");
        tablePropertiesEntity.setPropertyValue("Test Value");

        TablePropertiesEntity savedTablePropertiesEntity = tablePropertiesEntityRepository.save(tablePropertiesEntity);

        assertNotNull(savedTablePropertiesEntity);
        assertEquals("Test Catalog", savedTablePropertiesEntity.getCatalog());
        assertEquals("Test Schema", savedTablePropertiesEntity.getSchema());
        assertEquals("Test Table", savedTablePropertiesEntity.getTable());
        assertEquals("Test Property", savedTablePropertiesEntity.getPropertyName());
    }

    // Add more tests as needed
}
