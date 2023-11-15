create table catalogs
(
    name             varchar(200) not null
        primary key,
    properties       text,
    comment          text,
    connector_type   varchar(200),
    synchronize_time timestamp
);

create table mx_schema
(
    catalog_    varchar(200) not null,
    schema_     varchar(200) not null,
    schema_type varchar(200),
    comment_    text,
    constraint schema_pk
        primary key (catalog_, schema_)
);


create table mx_schema_properties
(
    catalog_       varchar(200),
    schema_        varchar(200),
    property_name  varchar(200),
    property_value varchar(200)
);


create table mx_table_properties
(
    catalog_       varchar(200) not null,
    schema_        varchar(200) not null,
    table_         varchar(200) not null,
    property_name  varchar(200) not null,
    property_value text,
    comment_       text,
    constraint mx_table_properties_pk
        primary key (catalog_, schema_, table_, property_name)
);

alter table mx_table_properties
    owner to postgres;

create table mx_table
(
    catalog_   varchar,
    schema_    varchar,
    table_     varchar,
    table_type varchar(200),
    comment_   text
);

create table mx_table_columns
(
    catalog_           varchar not null,
    schema_            varchar not null,
    table_             varchar not null,
    column_name        varchar not null,
    data_type          bigint,
    type_name          varchar,
    column_size        bigint,
    buffer_length      bigint,
    decimal_digits     bigint,
    num_prec_radix     bigint,
    nullable           bigint,
    remarks            varchar,
    column_def         varchar,
    sql_data_type      bigint,
    sql_datetime_sub   bigint,
    char_octet_length  bigint,
    ordinal_position   bigint,
    is_nullable        varchar,
    scope_catalog      varchar,
    scope_schema       varchar,
    scope_table        varchar,
    source_data_type   bigint,
    is_autoincrement   varchar,
    is_generatedcolumn varchar,
    constraint table_columns_pk
        primary key (catalog_, schema_, table_, column_name)
);
