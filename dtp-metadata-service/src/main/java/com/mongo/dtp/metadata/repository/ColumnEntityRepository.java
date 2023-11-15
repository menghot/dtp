package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.ColumnEntity;
import com.mongo.dtp.metadata.model.ColumnId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnEntityRepository
        extends JpaRepository<ColumnEntity, ColumnId>
{
    List<ColumnEntity> findByCatalogAndSchemaAndTable(String catalog, String schema, String table);
}
