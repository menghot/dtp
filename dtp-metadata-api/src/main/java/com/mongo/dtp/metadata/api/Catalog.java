package com.mongo.dtp.metadata.api;

import lombok.Data;

@Data
public class Catalog
{

    private String name;
    private String properties;
    private String comment;
    private String connectorType;
}
