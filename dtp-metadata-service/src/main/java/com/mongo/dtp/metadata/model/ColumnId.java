package com.mongo.dtp.metadata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class ColumnId
        implements Serializable
{

    private String catalog;
    private String schema;
    private String table;
    private String columnName;

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
        ColumnId columnId = (ColumnId) o;
        return catalog.equals(columnId.catalog) && schema.equals(columnId.schema) && table.equals(columnId.table) && columnName.equals(columnId.columnName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(catalog, schema, table, columnName);
    }
}
