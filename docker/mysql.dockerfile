FROM  mysql:latest
ENV MYSQL_ROOT_PASSWORD=w4rg4m35
ADD /scripts/sql/sec_eagrobusinessdb.sql  /docker-entrypoint-initdb.d
ADD /scripts/sql/sec_eagrobusinessdb_carga.sql  /docker-entrypoint-initdb.d