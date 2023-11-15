package com.mongo.dtp.metadata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class TablePropertiesId
        implements Serializable
{

    private String catalog;
    private String schema;
    private String table;
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
        TablePropertiesId that = (TablePropertiesId) o;
        return catalog.equals(that.catalog) && schema.equals(that.schema) && table.equals(that.table) && propertyName.equals(that.propertyName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalog, schema, table, propertyName);
    }
}
