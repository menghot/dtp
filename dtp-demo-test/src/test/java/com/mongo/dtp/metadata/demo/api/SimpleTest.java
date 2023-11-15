package com.mongo.dtp.metadata.demo.api;

import com.mongo.dtp.metadata.api.MetadataServiceClient;
import com.mongo.dtp.metadata.api.Catalog;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

public class SimpleTest
{

    Supplier<MetadataServiceClient> supplier = () -> Feign.builder().decoder(new JacksonDecoder()).target(MetadataServiceClient.class, "http://127.0.0.1:8081");

    @Test
    public void test()
    {
        List<Catalog> Catalogs = supplier.get().getCatalogs();

        Catalogs.iterator().forEachRemaining(c -> System.out.println(c.getName()));

        supplier.get().getSchemas("httpcsv").iterator().forEachRemaining(s -> System.out.println(s.getCatalog()));

        supplier.get().getTables("httpcsv", "example").iterator().forEachRemaining(t -> System.out.println(t.getName()));

    }
}
