package com.mongo.dtp.metadata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data

public class TableId
        implements Serializable
{

    private String catalog;
    private String schema;
    private String table;

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
        TableId that = (TableId) o;
        return catalog.equals(that.catalog) && schema.equals(that.schema) && table.equals(that.table);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalog, schema, table);
    }
}
