package com.mongo.dtp.metadata.repository;

import com.mongo.dtp.metadata.model.SchemaPropertiesEntity;
import com.mongo.dtp.metadata.model.SchemaPropertiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemaPropertiesEntityRepository
        extends JpaRepository<SchemaPropertiesEntity, SchemaPropertiesId>
{

}
