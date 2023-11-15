package com.mongo.dtp.metadata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mx_schema")
@IdClass(SchemaId.class)
@Data
public class SchemaEntity
{

    @Id
    @Column(name = "catalog_", length = 200, nullable = false)
    private String catalog;

    @Id
    @Column(name = "schema_", length = 200, nullable = false)
    private String schema;

    @Column(name = "schema_type", length = 200)
    private String schemaType;

    @Column(name = "comment_", columnDefinition = "text")
    private String comment;

    // Getters and setters
}
