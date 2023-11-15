package com.mongo.dtp.metadata.demo.repository;

import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.repository.TableEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TableEntityRepositoryTest
{

    @Autowired
    private TableEntityRepository tableEntityRepository;

    @Test
    @DirtiesContext
    public void testSaveTable()
    {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setCatalog("Test Catalog");
        tableEntity.setSchema("Test Schema");
        tableEntity.setTable("Test Table");
        tableEntity.setTableType("Test Type");
        tableEntity.setComment("Test Comment");

        TableEntity savedTableEntity = tableEntityRepository.save(tableEntity);

        assertNotNull(savedTableEntity);
        assertEquals("Test Catalog", savedTableEntity.getCatalog());
        assertEquals("Test Schema", savedTableEntity.getSchema());
        assertEquals("Test Table", savedTableEntity.getTable());
    }

    @Test
    @DirtiesContext
    public void testFindByCatalogAndSchema()
    {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setCatalog("Test Catalog");
        tableEntity.setSchema("Test Schema");
        tableEntity.setTable("Test Table");
        tableEntity.setTableType("Test Type");
        tableEntity.setComment("Test Comment");

        tableEntityRepository.save(tableEntity);

        List<TableEntity> tableEntities = tableEntityRepository.findByCatalogAndSchema(tableEntity.getCatalog(), tableEntity.getSchema());

        assertEquals(1, tableEntities.size());
    }

    // Add more tests as needed
}
