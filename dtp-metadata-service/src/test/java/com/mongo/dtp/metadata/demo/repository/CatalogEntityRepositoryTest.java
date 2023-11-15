package com.mongo.dtp.metadata.demo.repository;

import com.mongo.dtp.metadata.model.CatalogEntity;
import com.mongo.dtp.metadata.repository.CatalogEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CatalogEntityRepositoryTest
{

    @Autowired
    private CatalogEntityRepository catalogEntityRepository;

    @Test
    @DirtiesContext
    public void testSaveCatalog()
    {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setName("Test Catalog");
        catalogEntity.setProperties("Some properties");
        catalogEntity.setComment("Some comment");
        catalogEntity.setConnectorType("Test Connector");
        catalogEntity.setSynchronizeTime(null);

        CatalogEntity savedCatalogEntity = catalogEntityRepository.save(catalogEntity);

        assertNotNull(savedCatalogEntity);
        assertEquals("Test Catalog", savedCatalogEntity.getName());
    }

    @Test
    public void testFindById()
    {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setName("Test Catalog");
        catalogEntity.setProperties("Some properties");
        catalogEntity.setComment("Some comment");
        catalogEntity.setConnectorType("Test Connector");
        catalogEntity.setSynchronizeTime(null);

        catalogEntityRepository.save(catalogEntity);

        Optional<CatalogEntity> optionalCatalog = catalogEntityRepository.findById("Test Catalog");

        assertTrue(optionalCatalog.isPresent());
        assertEquals("Test Catalog", optionalCatalog.get().getName());
    }

    @Test
    public void testFindByIdNonExistent()
    {
        Optional<CatalogEntity> optionalCatalog = catalogEntityRepository.findById("NonExistent Catalog");

        assertTrue(optionalCatalog.isEmpty());
    }

    @Test
    @DirtiesContext
    public void testDeleteCatalog()
    {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setName("Test Catalog");
        catalogEntity.setProperties("Some properties");
        catalogEntity.setComment("Some comment");
        catalogEntity.setConnectorType("Test Connector");
        catalogEntity.setSynchronizeTime(null);

        catalogEntityRepository.save(catalogEntity);

        catalogEntityRepository.deleteById("Test Catalog");

        assertFalse(catalogEntityRepository.findById("Test Catalog").isPresent());
    }
}
