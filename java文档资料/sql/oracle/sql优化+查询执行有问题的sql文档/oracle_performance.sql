显示数据库当前的连接数

select count(*) from v$process;

 

显示数据库最大连接数：

select value from v$parameter where name ='processes' 

 

修改最大Oracle最大连接数:

alter system set processes = 300 scope = spfile;

 

显示当前的session连接数；

select count(*) fromv$session

 

查看当前有哪些用户正在使用数据

SELECT osuser, a.username,cpu_time/executions/1000000||'s', sql_fulltext,machine from v$session a, v$sqlarea b where a.sql_address =b.address order by cpu_time/executions desc;

 

查看数据库中SGA：

System global area (SGA),system global area(PGA);

 

查看连接oracle的所有机器的连接数

selectmachine,count(*) fromv$session groupbymachine;

查看连接oracle的所有机器的连接数和状态

selectmachine,status,count(*) fromv$session groupbymachine,status orderbystatus;

 

Oracle 11g设置内存自动管理: 

ALTERSYSTEM SETMEMORY_TARGET = 1024M SCOPE=SPFILE;

ALTERSYSTEM SETmemory_max_target = 1500M SCOPE=SPFILE;

ALTERSYSTEM SETSGA_TARGET = 0 SCOPE=SPFILE;

ALTERSYSTEM SETSGA_MAX_SIZE=800M SCOPE=SPFILE;

ALTERSYSTEM SETPGA_AGGREGATE_TARGET = 0 SCOPE=SPFILE;

altersystem setpre_page_sga=FALSEscope=spfile;

 

查看消耗磁盘读取最多的SQL Top 5：

select disk_reads,sql_text,SQL_FULLTEXT

from (select sql_text,disk_reads,SQL_FULLTEXT,

   dense_rank() over

     (order by disk_reads desc) disk_reads_rank

   from v$sql)

where disk_reads_rank <=5;

 

实例：

通过linux中消耗资源高的进程号获取oracle消耗资源的sql语句：

1、linux中使用top命名查看oracle进程中消耗资源最高的进程号；

2、oracle中使用命令：

select c.spid,a.p1,a.p1raw,a.p2,a.event,b.sql_text,b.SQL_FULLTEXT,b.SQL_ID 

from v$session a,v$sql b,v$process c 

where a.wait_class<>'Idle' and a.sql_id=b.sql_id and a.PADDR=c.addr 

order by event;

3、查询结果显示出各个sql语句对应的进程号，从中找出top命令中对应消耗资源高的进程号即可找到相应的sql语句。








1、寻找最多BUFFER_GETS开销的SQL 语句
--filename: top_sql_by_buffer_gets.sql
--Identify heavy SQL (Get the SQL with heavy BUFFER_GETS)
SET LINESIZE 190
COL sql_text FORMAT a100 WRAP
SET PAGESIZE 100
 
SELECT *
  FROM (  SELECT sql_text,
                 sql_id,
                 executions,
                 disk_reads,
                 buffer_gets
            FROM v$sqlarea
           WHERE DECODE (executions, 0, buffer_gets, buffer_gets / executions) >
                    (SELECT AVG (DECODE (executions, 0, buffer_gets, buffer_gets / executions))
                            + STDDEV (DECODE (executions, 0, buffer_gets, buffer_gets / executions))
                       FROM v$sqlarea)
                 AND parsing_user_id != 3D
        ORDER BY 5 DESC) x  /*更正@20140613,原来为order by 4,感谢网友lmalds指正*/
 WHERE ROWNUM <= 10;


2、寻找最多DISK_READS开销的SQL 语句
--filename:top_sql_disk_reads.sql
--Identify heavy SQL (Get the SQL with heavy DISK_READS)
SET LINESIZE 190
COL sql_text FORMAT a100 WRAP
SET PAGESIZE 100
 
SELECT *
  FROM (  SELECT sql_text,
                 sql_id,
                 executions,
                 disk_reads,
                 buffer_gets
            FROM v$sqlarea
           WHERE DECODE (executions, 0, disk_reads, disk_reads / executions) >
                    (SELECT AVG (DECODE (executions, 0, disk_reads, disk_reads / executions))
                            + STDDEV (DECODE (executions, 0, disk_reads, disk_reads / executions))
                       FROM v$sqlarea)
                 AND parsing_user_id != 3D
        ORDER BY 4 DESC) x  /* 更正@20140613,原来为order by 3,谢谢网友lmalds指正*/
 WHERE ROWNUM <= 10;
 


 3、寻找最近30分钟导致资源过高开销的事件
 --filename:top_event_in_30_min.sql
--Last 30 minutes result those resources that are in high demand on your system.
SET LINESIZE 180
COL event FORMAT a60
COL total_wait_time FORMAT 999999999999999999
 
  SELECT active_session_history.event,
         SUM (
            active_session_history.wait_time
            + active_session_history.time_waited)
            total_wait_time
    FROM v$active_session_history active_session_history
   WHERE active_session_history.sample_time BETWEEN SYSDATE - 60 / 2880
                                                AND SYSDATE
         AND active_session_history.event IS NOT NULL
GROUP BY active_session_history.event
ORDER BY 2 DESC;
 


4、查找最近30分钟内等待最多的用户
--filename:top_wait_by_user.sql
--What user is waiting the most?
 
SET LINESIZE 180
COL event FORMAT a60
COL total_wait_time FORMAT 999999999999999999
 
  SELECT ss.sid,
         NVL (ss.username, 'oracle') AS username,
         SUM (ash.wait_time + ash.time_waited) total_wait_time
    FROM v$active_session_history ash, v$session ss
   WHERE ash.sample_time BETWEEN SYSDATE - 60 / 2880 AND SYSDATE AND ash.session_id = ss.sid
GROUP BY ss.sid, ss.username
ORDER BY 3 DESC;
 


5、查找30分钟消耗最多资源的SQL语句
--filename:top_sql_by_wait.sql
-- What SQL is currently using the most resources?
SET LINESIZE 180
COL sql_text FORMAT a90 WRAP
COL username FORMAT a20 WRAP
SET PAGESIZE 200
 
SELECT *
  FROM (  SELECT sqlarea.sql_text,
                 dba_users.username,
                 sqlarea.sql_id,
                 SUM (active_session_history.wait_time + active_session_history.time_waited)
                    total_wait_time
            FROM v$active_session_history active_session_history, v$sqlarea sqlarea, dba_users
           WHERE     active_session_history.sample_time BETWEEN SYSDATE - 60 / 2880 AND SYSDATE
                 AND active_session_history.sql_id = sqlarea.sql_id
                 AND active_session_history.user_id = dba_users.user_id
        GROUP BY active_session_history.user_id,
                 sqlarea.sql_text,
                 sqlarea.sql_id,
                 dba_users.username
        ORDER BY 4 DESC) x
 WHERE ROWNUM <= 11;
 


6、等待最多的对象

--filename:top_object_by_wait.sql
--What object is currently causing the highest resource waits?
SET LINESIZE 180
COLUMN OBJECT_NAME FORMAT a30
COLUMN EVENT FORMAT a30
 
  SELECT dba_objects.object_name,
         dba_objects.object_type,
         active_session_history.event,
         SUM (active_session_history.wait_time + active_session_history.time_waited) ttl_wait_time
    FROM v$active_session_history active_session_history, dba_objects
   WHERE active_session_history.sample_time BETWEEN SYSDATE - 60 / 2880 AND SYSDATE
         AND active_session_history.current_obj# = dba_objects.object_id
GROUP BY dba_objects.object_name, dba_objects.object_type, active_session_history.event
ORDER BY 4 DESC;
 


7、寻找基于指定时间范围内的历史SQL语句
--注该查询受到awr快照相关参数的影响
-- filename:top_sql_in_spec_time.sql
--Top SQLs Elaps time and CPU time in a given time range..
--X.ELAPSED_TIME/1000000 => From Micro second to second
--X.ELAPSED_TIME/1000000/X.EXECUTIONS_DELTA => How many times the sql ran
 
SET PAUSE ON
SET PAUSE 'Press Return To Continue'
SET LINESIZE 180
COL sql_text FORMAT a80 WRAP
 
  SELECT sql_text,
         dhst.sql_id,
         ROUND (x.elapsed_time / 1000000 / x.executions_delta, 3) elapsed_time_sec,
         ROUND (x.cpu_time / 1000000 / x.executions_delta, 3) cpu_time_sec,
         x.elapsed_time,
         x.cpu_time,
         executions_delta AS exec_delta
    FROM dba_hist_sqltext dhst,
         (  SELECT dhss.sql_id sql_id,
                   SUM (dhss.cpu_time_delta) cpu_time,
                   SUM (dhss.elapsed_time_delta) elapsed_time,
                   CASE SUM (dhss.executions_delta) WHEN 0 THEN 1 ELSE SUM (dhss.executions_delta) END
                      AS executions_delta
              FROM dba_hist_sqlstat dhss
             WHERE dhss.snap_id IN
                      (SELECT snap_id
                         FROM dba_hist_snapshot
                        WHERE begin_interval_time >= TO_DATE ('&input_start_date', 'YYYYMMDD HH24:MI')
                              AND end_interval_time <= TO_DATE ('&input_end_date', 'YYYYMMDD HH24:MI'))
          GROUP BY dhss.sql_id) x
   WHERE x.sql_id = dhst.sql_id
ORDER BY elapsed_time_sec DESC;
 


8、寻找基于指定时间范围内及指定用户的历史SQL语句
--注该查询受到awr快照相关参数的影响
--Author : Robinson
--Blog   : http://blog.csdn.net/robinson_0612
 
SELECT DBMS_LOB.SUBSTR (sql_text, 4000, 1) AS sql,
         ROUND (x.elapsed_time / 1000000, 2) elapsed_time_sec,
         ROUND (x.cpu_time / 1000000, 2) cpu_time_sec,
         x.executions_delta AS exec_num,
         ROUND ( (x.elapsed_time / 1000000) / x.executions_delta, 2) AS exec_time_per_query_sec
    FROM dba_hist_sqltext dhst,
         (  SELECT dhss.sql_id sql_id,
                   SUM (dhss.cpu_time_delta) cpu_time,
                   SUM (dhss.elapsed_time_delta) elapsed_time,
                   CASE SUM (dhss.executions_delta) WHEN 0 THEN 1 ELSE SUM (dhss.executions_delta) END
                      AS executions_delta
              --DHSS.EXECUTIONS_DELTA = No of queries execution (per hour)
              FROM dba_hist_sqlstat dhss
             WHERE dhss.snap_id IN
                      (SELECT snap_id
                         FROM dba_hist_snapshot
                        WHERE begin_interval_time >= TO_DATE ('&input_start_date', 'YYYYMMDD HH24:MI')
                              AND end_interval_time <= TO_DATE ('&input_end_date', 'YYYYMMDD HH24:MI'))
                   AND dhss.parsing_schema_name LIKE UPPER ('%&input_username%')
          GROUP BY dhss.sql_id) x
   WHERE x.sql_id = dhst.sql_id
ORDER BY elapsed_time_sec DESC;
 


9、SQL语句被执行的次数

--exe_delta表明在指定时间内增长的次数
-- filename: sql_exec_num.sql
-- How many Times a query executed?
SET LINESIZE 180
SET VERIFY OFF
 
  SELECT TO_CHAR (s.begin_interval_time, 'yyyymmdd hh24:mi:ss'),
         sql.sql_id AS sql_id,
         sql.executions_delta AS exe_delta,
         sql.executions_total
    FROM dba_hist_sqlstat sql, dba_hist_snapshot s
   WHERE     sql_id = '&input_sql_id'
         AND s.snap_id = sql.snap_id
         AND s.begin_interval_time > TO_DATE ('&input_start_date', 'YYYYMMDD HH24:MI')
         AND s.begin_interval_time < TO_DATE ('&input_end_date', 'YYYYMMDD HH24:MI')
ORDER BY s.begin_interval_time;
 


