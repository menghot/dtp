package com.mongo.dtp.metadata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mx_table_columns")
@IdClass(ColumnId.class)
@Data
public class ColumnEntity
{

    @Id
    @jakarta.persistence.Column(name = "catalog_", length = 200, nullable = false)
    private String catalog;

    @Id
    @jakarta.persistence.Column(name = "schema_", length = 200, nullable = false)
    private String schema;

    @Id
    @jakarta.persistence.Column(name = "table_", length = 200, nullable = false)
    private String table;

    @Id
    @jakarta.persistence.Column(name = "column_name", length = 200)
    private String columnName;

    @jakarta.persistence.Column(name = "data_type")
    private Long dataType;

    @jakarta.persistence.Column(name = "type_name", length = 200)
    private String typeName;

    @jakarta.persistence.Column(name = "column_size")
    private Long columnSize;

    @jakarta.persistence.Column(name = "buffer_length")
    private Long bufferLength;

    @jakarta.persistence.Column(name = "decimal_digits")
    private Long decimalDigits;

    @jakarta.persistence.Column(name = "num_prec_radix")
    private Long numPrecRadix;

    @jakarta.persistence.Column(name = "nullable")
    private Long nullable;

    @jakarta.persistence.Column(name = "remarks", length = 200)
    private String remarks;

    @jakarta.persistence.Column(name = "column_def", length = 200)
    private String columnDef;

    @jakarta.persistence.Column(name = "sql_data_type")
    private Long sqlDataType;

    @jakarta.persistence.Column(name = "sql_datetime_sub")
    private Long sqlDatetimeSub;

    @jakarta.persistence.Column(name = "char_octet_length")
    private Long charOctetLength;

    @jakarta.persistence.Column(name = "ordinal_position")
    private Long ordinalPosition;

    @jakarta.persistence.Column(name = "is_nullable", length = 200)
    private String isNullable;

    @jakarta.persistence.Column(name = "scope_catalog", length = 200)
    private String scopeCatalog;

    @jakarta.persistence.Column(name = "scope_schema", length = 200)
    private String scopeSchema;

    @jakarta.persistence.Column(name = "scope_table", length = 200)
    private String scopeTable;

    @jakarta.persistence.Column(name = "source_data_type")
    private Long sourceDataType;

    @jakarta.persistence.Column(name = "is_autoincrement", length = 200)
    private String isAutoincrement;

    @jakarta.persistence.Column(name = "is_generatedcolumn", length = 200)
    private String isGeneratedColumn;

    // Getters and setters
}
