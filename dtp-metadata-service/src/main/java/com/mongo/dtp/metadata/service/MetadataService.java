package com.mongo.dtp.metadata.service;

import com.mongo.dtp.metadata.model.CatalogEntity;
import com.mongo.dtp.metadata.model.ColumnEntity;
import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.model.TableId;
import com.mongo.dtp.metadata.model.TablePropertiesEntity;

import java.util.List;
import java.util.Optional;

public interface MetadataService
{

    List<CatalogEntity> getCatalogs();

    List<SchemaEntity> getSchemas(String catalog);

    List<TableEntity> getTables(String catalog, String schema);

    Optional<TableEntity> getTable(TableId tableId);

    List<ColumnEntity> getTableColumns(String catalog, String schema, String table);

    List<TablePropertiesEntity> getTableProperties(String catalog, String schema, String table);
}
