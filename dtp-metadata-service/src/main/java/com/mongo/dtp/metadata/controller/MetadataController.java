package com.mongo.dtp.metadata.controller;

import com.mongo.dtp.metadata.model.CatalogEntity;
import com.mongo.dtp.metadata.model.ColumnEntity;
import com.mongo.dtp.metadata.model.SchemaEntity;
import com.mongo.dtp.metadata.model.TableEntity;
import com.mongo.dtp.metadata.model.TableId;
import com.mongo.dtp.metadata.model.TablePropertiesEntity;
import com.mongo.dtp.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetadataController
{
    private MetadataService metadataService;

    @Autowired
    public MetadataController(MetadataService metadataService)
    {
        this.metadataService = metadataService;
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<CatalogEntity>> getCatalogs()
    {
        return ResponseEntity.ok(metadataService.getCatalogs());
    }

    @GetMapping("/catalogs/{catalog}/schemas")
    public ResponseEntity<List<SchemaEntity>> getSchemas(@PathVariable String catalog)
    {
        return ResponseEntity.ok(metadataService.getSchemas(catalog));
    }

    @GetMapping("/catalogs/{catalog}/schemas/{schema}/tables")
    public ResponseEntity<List<TableEntity>> getTables(@PathVariable String catalog, @PathVariable String schema)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-MY-Header", "SIMON");
        return ResponseEntity.ok().headers(headers).body(metadataService.getTables(catalog, schema));
    }

    @GetMapping("/catalogs/{catalog}/schemas/{schema}/tables/{table}")
    public ResponseEntity<TableEntity> getTables(@PathVariable String catalog, @PathVariable String schema, @PathVariable String table)
    {

        TableId tableId = new TableId();
        tableId.setCatalog(catalog);
        tableId.setSchema(schema);
        tableId.setTable(table);

        return ResponseEntity.ok(metadataService.getTable(tableId).get());
    }

    @GetMapping("/catalogs/{catalog}/schemas/{schema}/tables/{table}/columns")

    public ResponseEntity<List<ColumnEntity>> getColumns(@PathVariable String catalog, @PathVariable String schema, @PathVariable String table)
    {
        return ResponseEntity.ok(metadataService.getTableColumns(catalog, schema, table));
    }

    @GetMapping("/catalogs/{catalog}/schemas/{schema}/tables/{table}/properties")

    public ResponseEntity<List<TablePropertiesEntity>> getTableProperties(@PathVariable String catalog, @PathVariable String schema, @PathVariable String table)
    {
        return ResponseEntity.ok(metadataService.getTableProperties(catalog, schema, table));
    }
}
