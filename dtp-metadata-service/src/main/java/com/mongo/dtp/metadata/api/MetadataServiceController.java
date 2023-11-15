package com.mongo.dtp.metadata.api;

import com.mongo.dtp.metadata.model.CatalogEntity;
import com.mongo.dtp.metadata.model.ColumnEntity;
import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.model.TableId;
import com.mongo.dtp.metadata.service.MetadataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class MetadataServiceController
        implements MetadataServiceClient
{

    private MetadataService metadataService;

    @Autowired
    public MetadataServiceController(MetadataService metadataService)
    {
        this.metadataService = metadataService;
    }

    @Override
    public List<Catalog> getCatalogs()
    {
        List<CatalogEntity> catalogEntities = metadataService.getCatalogs();
        return catalogEntities.stream().map(convertCatalog).collect(Collectors.toList());
    }

    @Override
    public List<Schema> getSchemas(String catalog)
    {
        List<SchemaEntity> schemaEntities = metadataService.getSchemas(catalog);
        return schemaEntities.stream().map(convertSchemas).collect(Collectors.toList());
    }

    @Override
    public List<Table> getTables(String catalog, String schema)
    {
        List<TableEntity> entities = metadataService.getTables(catalog, schema);
        return entities.stream().map(convertTable).collect(Collectors.toList());
    }

    @Override
    public Table getTable(String catalog, String schema, String table)
    {

        TableId tableId = new TableId();
        tableId.setCatalog(catalog);
        tableId.setSchema(schema);
        tableId.setTable(table);

        Optional<TableEntity> tableEntity = metadataService.getTable(tableId);
        if (tableEntity.isPresent()) {
            Table result = new Table();
            result.setCatalog(catalog);
            result.setSchema(schema);
            result.setName(table);
            result.setComment(tableEntity.get().getComment());

            Map<String, String> properties = new HashMap<>();
            metadataService.getTableProperties(catalog, schema, table).iterator().forEachRemaining(entity -> properties.put(entity.getPropertyName(), entity.getPropertyValue()));
            result.setProperties(properties);
            List<Column> columns = new ArrayList<>();
            metadataService.getTableColumns(catalog, schema, table).iterator().forEachRemaining(entity -> columns.add(convertColumn.apply(entity)));
            result.setColumns(columns);
            return result;
        }

        return null;
    }

    Function<ColumnEntity, Column> convertColumn = entity -> {
        Column column = new Column();
        BeanUtils.copyProperties(entity, column);
        column.setName(entity.getColumnName());
        return column;
    };





    @Override

    public List<Column> getColumns(String catalog, String schema, String table)
    {
        return null;
    }

    Function<CatalogEntity, Catalog> convertCatalog = entity -> {
        Catalog catalog = new Catalog();
        BeanUtils.copyProperties(entity, catalog);
        return catalog;
    };

    Function<SchemaEntity, Schema> convertSchemas = entity -> {
        Schema schema = new Schema();
        BeanUtils.copyProperties(entity, schema);
        schema.setName(entity.getSchema());
        return schema;
    };

    Function<TableEntity, Table> convertTable = entity -> {
        Table table = new Table();
        BeanUtils.copyProperties(entity, table);
        table.setName(entity.getTable());
        return table;
    };
}
