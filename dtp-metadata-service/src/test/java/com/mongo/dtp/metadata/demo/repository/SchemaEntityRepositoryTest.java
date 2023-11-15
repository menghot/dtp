package com.mongo.dtp.metadata.demo.repository;

import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.SchemaId;
import com.mongo.dtp.metadata.repository.SchemaEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class SchemaEntityRepositoryTest
{

    @Autowired private SchemaEntityRepository schemaEntityRepository;

    @Test
    @DirtiesContext
    public void testSaveSchema()
    {
        SchemaEntity schemaEntity = new SchemaEntity();
        schemaEntity.setCatalog("Test Catalog");
        schemaEntity.setSchema("Test Schema");
        schemaEntity.setSchemaType("Test Type");
        schemaEntity.setComment("Test Comment");

        SchemaEntity savedSchemaEntity = schemaEntityRepository.save(schemaEntity);

        assertNotNull(savedSchemaEntity);
        assertEquals("Test Catalog", savedSchemaEntity.getCatalog());
        assertEquals("Test Schema", savedSchemaEntity.getSchema());
    }

    @Test
    public void testFindSchemaById()
    {

        SchemaEntity schemaEntity = new SchemaEntity();
        schemaEntity.setCatalog("Test Catalog");
        schemaEntity.setSchema("Test Schema");
        schemaEntity.setSchemaType("Test Type");
        schemaEntity.setComment("Test Comment");

        SchemaEntity savedSchemaEntity = schemaEntityRepository.save(schemaEntity);

        SchemaId schemaId = new SchemaId();
        schemaId.setCatalog(savedSchemaEntity.getCatalog());
        schemaId.setSchema(savedSchemaEntity.getSchema());

        Optional<SchemaEntity> findedSchema = schemaEntityRepository.findById(schemaId);

        assertTrue(findedSchema.isPresent());
    }

    @Test
    public void testFindSchemaByCatalog()
    {

        SchemaEntity schemaEntity = new SchemaEntity();
        schemaEntity.setCatalog("Test Catalog");
        schemaEntity.setSchema("Test Schema");
        schemaEntity.setSchemaType("Test Type");
        schemaEntity.setComment("Test Comment");

        schemaEntityRepository.save(schemaEntity);

        List<SchemaEntity> findedSchemaEntity = schemaEntityRepository.findByCatalog(schemaEntity.getCatalog());

        assertFalse(findedSchemaEntity.isEmpty());
    }

    // Add more tests as needed
}
