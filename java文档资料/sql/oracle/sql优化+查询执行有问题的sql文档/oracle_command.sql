-- 启动监听
lsnrctl start|stop；
-- 进入sqlplus界面
sqlplus /nolog
sql> conn sys/oracle@orcl as sysdba;
-- 启动数据库实例
sql> startup;
sql> shutdown immediate;
-- 查询库所有schema
select * from v$database;
select name fomr v$database;
-- 查看哪些用户拥有sysdba，sysoper权限
select * from v$pwfile_users;
-- 查看当前数据库连接用户
show user;
-- 进入test数据库：
database test;
-- 查看数据库结构：
desc v$database;
-- 查看所有用户实例：
select * from v$instance;
-- 查看当前库的所有数据表
select * from all_tables;
select table_name from all_tables;
   
select table_name from all_tables where owner='用户名';
-- 查看表结构
desc 表名;
-- 增加数据库用户
create user knight identified by knight default tablespace users Temporary TABLESPACE Temp;
-- 用户授权
grant connect,resource,dba to 用户名;
grant sysdba to 用户名;
-- 更改数据库用户密码
alter user 用户名 identified by 密码;	
-- 删除用户
select username,default_tablespace from dba_users;
drop user 用户名 cascade;
drop tablespace 空间名 INCLUDING CONTENTS AND DATAFILES;

--导入导出
1、EXP: 
   有三种主要的方式（完全、用户、表） 
   1、完全： 
      exp sys/oracle rows=y indexes=n compress=y buffer=65536 feedback=100000 full=y file=exp_.dmp log=exp.log
      如果要执行完全导出，必须具有dba权限 
   2、用户模式： 
      exp icdmain/icd owner=icdmain rows=y indexes=n compress=y buffer=65536 feedback=100000 file=exp.dmp log=exp.log
      这样用户icdmain的所有对象被输出到文件中。 
   3、表模式：
      exp icdmain/icd rows=y indexes=n compress=y buffer=65536 feedback=100000 volsize=0 file=exp.dmp log=exp.log tables=tab1,tab2,tab3
      这样用户icdmain的表tab1,tab2,tab3就被导出 
2、IMP: 
   具有三种模式（完全、用户、表） 
   1、完全： 
      imp sys/oracle rows=y indexes=n commit=y buffer=65536 feedback=100000 ignore=y volsize=0 full=y file=exp.dmp log=imp.log
   2、用户模式： 
      imp icdmain/icd fromuser=icdmain touser=icdmain rows=y indexes=n commit=y buffer=65536 feedback=100000 ignore=n file=exp.dmp log=imp.log
      这样用户icdmain的所有对象被导入到文件中。必须指定FROMUSER、TOUSER参数，这样才能导入数据。 
   3、表模式： 
      imp icdmain/icd fromuser=icdmain touser=icdmain rows=y indexes=n commit=y buffer=65536 feedback=100000 ignore=n volsize=0 file=exp.dmp log=imp.log tables=t1,t2,t3
      这样用户icdmain的表t1,t2,t3就被导入
-- 字符
-- 数据库字符
select userenv('language') from dual;
-- 客户端字符
echo $NLS_LANG


-- 查看表所占用空间大小
SELECT TABLESPACE_NAME,TO_CHAR(SUM(BYTES)/(1024*1024),'999G999D999')   CNT_MB   
  FROM DBA_EXTENTS   
  WHERE OWNER='&OWNER'   AND   SEGMENT_NAME='&TABLE_NAME'   AND   SEGMENT_TYPE   LIKE   'TABLE%'   
  GROUP BY   TABLESPACE_NAME; 
-- 查看表空间总容量
select tablespace_name, sum(maxbytes) total from dba_data_files t where t.tablespace_name = 'USERS' group by tablespace_name;
-- 查看表空间已占用量
select TABLESPACE_NAME,sum(bytes) from dba_segments where tablespace_name='USERS' group by tablespace_name;

-- 清理表空间
purge recyclebin;
purge user_recyclebin;
purge dba_recyclebin;
-- 清理审计表，释放系统表空间
truncate table SYS.AUD$;

-- 同义词
