package com.mongo.dtp.metadata.service;

import com.mongo.dtp.metadata.model.CatalogEntity;
import com.mongo.dtp.metadata.model.ColumnEntity;
import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.model.TableId;
import com.mongo.dtp.metadata.model.TablePropertiesEntity;
import com.mongo.dtp.metadata.repository.CatalogEntityRepository;
import com.mongo.dtp.metadata.repository.ColumnEntityRepository;
import com.mongo.dtp.metadata.repository.SchemaEntityRepository;
import com.mongo.dtp.metadata.repository.TableEntityRepository;
import com.mongo.dtp.metadata.repository.TablePropertiesEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetadataServiceImpl
        implements MetadataService

{
    private CatalogEntityRepository catalogEntityRepository;
    private SchemaEntityRepository schemaEntityRepository;
    private TableEntityRepository tableEntityRepository;
    private ColumnEntityRepository columnEntityRepository;
    private TablePropertiesEntityRepository tablePropertiesEntityRepository;

    @Autowired
    public MetadataServiceImpl(CatalogEntityRepository catalogEntityRepository,
            SchemaEntityRepository schemaEntityRepository,
            TableEntityRepository tableEntityRepository,
            ColumnEntityRepository columnEntityRepository,
            TablePropertiesEntityRepository tablePropertiesEntityRepository)
    {
        this.catalogEntityRepository = catalogEntityRepository;
        this.schemaEntityRepository = schemaEntityRepository;
        this.tableEntityRepository = tableEntityRepository;
        this.columnEntityRepository = columnEntityRepository;
        this.tablePropertiesEntityRepository = tablePropertiesEntityRepository;
    }

    @Override
    public List<CatalogEntity> getCatalogs()
    {
        return catalogEntityRepository.findAll();
    }

    @Override
    public List<SchemaEntity> getSchemas(String catalog)
    {
        return schemaEntityRepository.findByCatalog(catalog);
    }

    @Override
    public List<TableEntity> getTables(String catalog, String schema)
    {
        return tableEntityRepository.findByCatalogAndSchema(catalog, schema);
    }

    @Override
    public Optional<TableEntity> getTable(TableId tableId)
    {
        return tableEntityRepository.findById(tableId);
    }

    @Override
    public List<ColumnEntity> getTableColumns(String catalog, String schema, String table)
    {
        return columnEntityRepository.findByCatalogAndSchemaAndTable(catalog, schema, table);
    }

    @Override
    public List<TablePropertiesEntity> getTableProperties(String catalog, String schema, String table)
    {
        return tablePropertiesEntityRepository.findByCatalogAndSchemaAndTable(catalog, schema, table);
    }
}
