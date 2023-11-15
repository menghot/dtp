package com.mongo.dtp.metadata.api;

import lombok.Data;

@Data
public class Column
{
    private String catalog;
    private String schema;
    private String table;
    private String name;
    private Long dataType;
    private String typeName;
    private Long columnSize;
    private Long bufferLength;
    private Long decimalDigits;
    private Long numPrecRadix;
    private Long nullable;
    private String remarks;
    private String columnDef;
    private Long sqlDataType;
    private Long sqlDatetimeSub;
    private Long charOctetLength;
    private Long ordinalPosition;
    private String isNullable;
    private String scopeCatalog;
    private String scopeSchema;
    private String scopeTable;
    private Long sourceDataType;
    private String isAutoincrement;
    private String isGeneratedColumn;
}
