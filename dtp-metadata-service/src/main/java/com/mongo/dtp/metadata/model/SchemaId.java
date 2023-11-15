package com.mongo.dtp.metadata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class SchemaId
        implements Serializable
{

    private String catalog;

    private String schema;

    // Implement equals and hashCode

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SchemaId schemaId = (SchemaId) o;
        return catalog.equals(schemaId.catalog) && schema.equals(schemaId.schema);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalog, schema);
    }
}
