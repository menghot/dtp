package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.TablePropertiesEntity;
import com.mongo.dtp.metadata.model.TablePropertiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablePropertiesEntityRepository
        extends JpaRepository<TablePropertiesEntity, TablePropertiesId>
{
    List<TablePropertiesEntity> findByCatalogAndSchemaAndTable(String catalog, String schema, String table);
}
