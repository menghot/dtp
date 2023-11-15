package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogEntityRepository
        extends JpaRepository<CatalogEntity, String>
{
}
