package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.model.TableId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableEntityRepository
        extends JpaRepository<TableEntity, TableId>
{

    List<TableEntity> findByCatalogAndSchema(String catalog, String schema);
}
