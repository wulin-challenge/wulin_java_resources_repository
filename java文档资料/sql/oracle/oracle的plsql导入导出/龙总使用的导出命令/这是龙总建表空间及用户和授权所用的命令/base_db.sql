create tablespace OASYS datafile 'D:\app\Administrator\oradata\orcl\OASYS.dbf' size 100M autoextend on;
drop user OASYS cascade;
create user OASYS identified by OASYS default tablespace OASYS;
grant connect,resource,dba to OASYS;

create tablespace OAAPP datafile 'D:\app\Administrator\oradata\orcl\OAAPP.dbf' size 100M autoextend on;
drop user OAAPP cascade;
create user OAAPP identified by OAAPP default tablespace OAAPP;
grant connect,resource,dba to OAAPP;

create tablespace OADOC datafile 'D:\app\Administrator\oradata\orcl\OADOC.dbf' size 100M autoextend on;
drop user OADOC cascade;
create user OADOC identified by OADOC default tablespace OADOC;
grant connect,resource,dba to OADOC;

create tablespace OAEDI_TS datafile 'D:\app\Administrator\oradata\orcl\OAEDI_TS.dbf' size 100M autoextend on;
drop user OAEDI cascade;
create user OAEDI identified by OAEDI default tablespace OAEDI_TS;
grant connect,resource,dba to OAEDI;
