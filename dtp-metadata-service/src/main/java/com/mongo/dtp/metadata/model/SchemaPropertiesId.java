package com.mongo.dtp.metadata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class SchemaPropertiesId
        implements Serializable
{

    private String catalog;
    private String schema;
    private String propertyName;

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
        SchemaPropertiesId that = (SchemaPropertiesId) o;
        return catalog.equals(that.catalog) && schema.equals(that.schema) && propertyName.equals(that.propertyName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalog, schema, propertyName);
    }
}
