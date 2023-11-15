package com.mongo.dtp.metadata.api;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Table
{
    private String catalog;
    private String schema;
    private String name;
    private String comment;
    private Map<String, String> properties;
    private List<Column> columns;

}
