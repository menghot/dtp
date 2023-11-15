package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.SchemaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemaEntityRepository
        extends JpaRepository<SchemaEntity, SchemaId>
{

    List<SchemaEntity> findByCatalog(String catalog);
}
