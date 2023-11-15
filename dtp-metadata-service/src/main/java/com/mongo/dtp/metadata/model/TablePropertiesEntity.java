package com.mongo.dtp.metadata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mx_table_properties")
@IdClass(TablePropertiesId.class)
@Data
public class TablePropertiesEntity
{

    @Id
    @Column(name = "catalog_", length = 200, nullable = false)
    private String catalog;

    @Id
    @Column(name = "schema_", length = 200, nullable = false)
    private String schema;

    @Id
    @Column(name = "table_", length = 200, nullable = false)
    private String table;

    @Id
    @Column(name = "property_name", length = 200)
    private String propertyName;

    @Column(name = "property_value", columnDefinition = "text")
    private String propertyValue;

    @Column(name = "comment_", columnDefinition = "text")
    private String comment;

    // Getters and setters
}
