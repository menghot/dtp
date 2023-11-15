package com.mongo.dtp.metadata.api;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dtp-metadata-service")
public interface MetadataServiceClient
{
    @GetMapping("/client/catalogs")
    @RequestLine("GET /client/catalogs")
    List<Catalog> getCatalogs();

    @GetMapping("/client/catalogs/{catalog}/schemas")
    @RequestLine("GET /client/catalogs/{catalog}/schemas")
    List<Schema> getSchemas(@PathVariable @Param String catalog);

    @GetMapping("/client/catalogs/{catalog}/schemas/{schema}/tables")
    @RequestLine("GET /client/catalogs/{catalog}/schemas/{schema}/tables")
    List<Table> getTables(@PathVariable @Param String catalog, @PathVariable @Param String schema);

    @GetMapping({"/client/catalogs/{catalog}/schemas/{schema}/tables/{table}"})
    @RequestLine("GET /client/catalogs/{catalog}/schemas/{schema}/tables/{table}")
    Table getTable(@PathVariable @Param String catalog, @PathVariable @Param String schema, @PathVariable @Param String table);

    @GetMapping("/client/catalogs/{catalog}/schemas/{schema}/tables/{table}/columns")
    @RequestLine("GET /client/catalogs/{catalog}/schemas/{schema}/tables/{table}/columns")
    List<Column> getColumns(@PathVariable @Param String catalog, @PathVariable @Param String schema, @PathVariable @Param String table);
}