package com.mongo.dtp.metadata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mx_schema_properties")
@IdClass(SchemaPropertiesId.class)
@Data
public class SchemaPropertiesEntity
{

    @Id
    @Column(name = "catalog_", length = 200)
    private String catalog;

    @Id
    @Column(name = "schema_", length = 200)
    private String schema;

    @Column(name = "property_name", length = 200)
    private String propertyName;

    @Column(name = "property_value", length = 200)
    private String propertyValue;

    // Getters and setters
}
