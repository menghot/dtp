package com.mongo.dtp.metadata.api;

import lombok.Data;

import java.util.List;

@Data
public class Schema
{
    String catalog;
    String name;
    String comment;
    List<Table> tables;
}
