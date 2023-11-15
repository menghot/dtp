package com.mongo.dtp.metadata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "catalogs")
@Data
public class CatalogEntity
{

    @Id
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "properties", columnDefinition = "text")
    private String properties;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "connector_type", length = 200)
    private String connectorType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "synchronize_time")
    private Date synchronizeTime;
}
