FROM  mysql:5.7
ADD /scripts/sql/sec_eagrobusinessdb.sql  /docker-entrypoint-initdb.d
ADD /scripts/sql/sec_eagrobusinessdb_carga.sql  /docker-entrypoint-initdb.d