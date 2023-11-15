package com.mongo.dtp.metadata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "mx_table")
@IdClass(TableId.class)
@Data
public class TableEntity
{

    @Id @Column(name = "catalog_") private String catalog;

    @Id @Column(name = "schema_") private String schema;

    @Id @Column(name = "table_") private String table;

    @Column(name = "table_type", length = 200) private String tableType;

    @Column(name = "comment_", columnDefinition = "text") private String comment;

    // Getters and setters
}
