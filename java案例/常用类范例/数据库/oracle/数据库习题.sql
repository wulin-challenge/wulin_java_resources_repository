说明:(1、一共41题，满分100分，36题20分，其余每题2分，时间120分钟
      2、以下的操作都是在scott用户下
   )
要求:将答案直接写在每题的下面(必须按规范写)

--1、请从表中查询工作是CLERK的所有人的姓名、工资、部门号、部门名称以及部门地址的信息

SELECT e.ename , e.sal ,e.deptno ,d.dname ,d.loc
FROM emp e ,dept d
WHERE e.deptno=d.deptno and e.job='CLERK'

--2、查询表EMP中所有的工资大于等于2000的雇员姓名和他的经理的名字

SELECT e.ename ,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno AND e.sal>=2000


--3、在表EMP中查询所有工资高于JONES的所有雇员姓名、工作和工资

SELECT ename,job,sal
FROM emp
WHERE sal>(SELECT sal
FROM emp 
WHERE ename='JONES')

--4、列出没有对应部门表信息的所有雇员的姓名、工作以及部门号

SELECT e.ename,e.job,e.deptno
FROM emp e
WHERE not exists(SELECT 1
FROM dept d 
WHERE e.deptno=d.deptno)

--5、查找工资在1000～3000之间的雇员所在部门的所有人员信息
select * from emp 
where deptno in(

SELECT dictinct e.deptno 
WHERE e.sal>=1000 AND e.sal<=3000
)

方法二:

SELECT e.* 
FROM emp e
WHERE exists (SELECT 1 FROM (SELECT distinct deptno FROM emp 
                             WHERE sal between 1000 and 3000) a 
              WHERE e.deptno=a.deptno)

--6、查询所有雇员的姓名、SAL与COMM之和

SELECT ename,nvl(sal,0)+nvl(comm,0)
FROM emp

--7、查询所有81年7月1日以前来的员工姓名、工资、所属部门的名字

SELECT e.ename,e.sal,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno(+) AND e.hiredate<to_date('1981/7/1','yyyy/MM/dd')

--8、查询各部门中81年1月1日以后来的员工数

SELECT d.dname, count(e.ename)
FROM emp e ,dept d
WHERE e.deptno=d.deptno AND e.hiredate>to_date('1981/1/1','yyyy/MM/dd')
GROUP BY d.dname

--9、查询所有在CHICAGO工作的经理MANAGER和销售员SALESMAN的姓名、工资

SELECT e.ename,e.sal
FROM emp e,dept d
WHERE e.deptno=d.deptno AND d.loc='CHECAGO' AND e.job='MANAGER' OR e.job='SALESMAN'

方法二:但这种效率低

SELECT e.ename ,e.sal 
FROM emp e ,dept d
WHERE e.deptno=d.deptno and d.loc='CHICAGO'
AND e.job in('MANAGER','SELESMAN')

--10、查询于81年来公司所有员工的总收入（SAL和COMM）

方法二:老师

SELECT sum(sal+nvl(comm,0))
FROM emp 
WHERE to_char(hiredate,'yyyy')='1981'

--11、查询公司中按年份月份统计各地的录用职工数量
SELECT to_char(e.hiredate,'yyyy-MM'),d.loc,count(e.empno)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY to_char(e.hiredate,'yyyy-MM'),d.loc

--12、查询列出各部门的部门名和部门经理名字 ---

SELECT *
FROM emp e,dept d
WHERE e.deptno=d.deptno AND job='MANAGER'


--13、 查询部门平均工资最高的部门名称 
SELECT na.name
FROM (SELECT d.dname name,avg(sal) average
     FROM emp e,dept d
     WHERE e.deptno=d.deptno
     GROUP BY d.dname) na,(
           SELECT max(average) maxAverage
           FROM (SELECT d.dname name,avg(sal) average
                FROM emp e,dept d
                WHERE e.deptno=d.deptno
                GROUP BY d.dname))ma
WHERE na.average=ma.maxAverage

方法二:
SELECT d.dname 
FROM dept d , (
              SELECT rownum ,t.*
              FROM (
                    SELECT deptno,avg(sal) 
                    FROM emp 
                    GROUP BY deptno
                    ORDER BY avg(sal) desc ) t
              WHERE rownum =1 ) a
WHERE d.deptno=a.deptno



--14、从emp中查出雇员编号为7369的员工的信息(显示雇员编号，雇员名称，从事工作，工资)

SELECT empno,ename,job,sal
FROM emp 
WHERE empno=7369

--15、从emp中找出工资为1500到4000之间的员工

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000

--16、从emp中找出工资为1500到4000之间的员工，并且从事的是销售的工作

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000 AND job='SALESMAN'

--17、从emp中找出工资为1500到4000之间的员工，按工资的降序排列，工资相同的按入职日期降序排列

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000
ORDER BY sal desc,hiredate desc


--18、从emp中找出工种是ANALYST，CLERK的人员

SELECT *
FROM emp
WHERE job='ANALYST' OR job='CLERK'

--19、列出所有“CLERK”的姓名及其部门名称

SELECT e.ename ,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno AND job='CLERK'

--20、从emp中找出姓名是以J开头员工的信息，并按工资的降序排列
SELECT *
FROM emp
WHERE ename like 'J%'
ORDER BY sal desc


--21、从emp中找出受雇日期早于1987/4/19的员工信息

SELECT *
FROM emp
WHERE hiredate<to_date('1987/4/19','yyyy-MM-dd')

--22、列出受雇日期早于其直接上级的所有员工

SELECT e.*
FROM emp e,emp m
WHERE e.mgr=m.empno AND e.hiredate<m.hiredate

--23、从emp中找出雇员的上级是7698的员工信息，并按工资的降序排列
SELECT *
FROM emp e
WHERE e.mgr=7698
ORDER BY sal desc


--24、列出薪金比“SMITH”多的所有员工

SELECT *
FROM emp e
WHERE e.sal>(SELECT sal
FROM emp 
WHERE ename='SMITH')

--25、列出薪金高于公司平均薪金的所有员工

SELECT *
FROM emp
WHERE sal>(SELECT avg(sal)
FROM emp
)

--26、列出与“SCOTT”从事相同工作的所有员工
SELECT *
FROM emp
WHERE job=(SELECT job
FROM emp
WHERE  ename='SCOTT') AND ename!='SCOTT'


--27、列出在部门“SALES”工作的员工的姓名，并按工资降序排列

SELECT ename,sal
FROM emp
WHERE (SELECT deptno
FROM dept
WHERE dname='SALES')=deptno
ORDER BY sal desc

--28、列出薪金高于在部门30工作的所有的员工的薪金的员工姓名和薪金

SELECT ename,sal
FROM emp 
WHERE sal>(SELECT max(sal)
FROM emp
WHERE deptno=30)

--29、列出员工的工号，姓名，原工资，新工资(对从事CLERK的+200，对从事SALESMAN+300，其他人员工资不变)--

SELECT sal+200 cs
FROM emp 
WHERE job='CLERK'

SELECT sal+300 ss
FROM emp 
WHERE job='SALESMAN'

SELECT empno,ename,sal,newsal
FROM emp
WHERE 

--30、列出所有员工的姓名及其直接上级的姓名

SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno

--31、列出最低薪金大于1500的各种工作，并按降序排列

SELECT job
FROM (SELECT *
     FROM emp
     ORDER BY sal desc)
GROUP BY job
HAVING min(sal)>1500



--32、列出每个部门工作的员工数量、平均工资，并按平均降序排序

SELECT count(e.ename),avg(e.sal)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.dname
ORDER BY avg(e.sal) desc

方法二:老师
SELECT d.dname,nvl(a.c,0),nvl(a.b,0)
FROM dept d,(SELECT deptno,count(*) c,avg(sal) b
                    FROM emp
                    GROUP BY deptno ) a
WHERE d.deptno=a.deptno(+)
ORDER BY nvl(a.b,0) desc


--33、列出所有员工的姓名，部门名称和工资

SELECT e.ename,d.dname,e.sal
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

--34、列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门

SELECT d.dname,e.ename
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

--35、列出各种工作的最低工资

SELECT min(e.sal)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.dname

--36、创建一张订单表,字段有(订单号 主键，订单状态，订货人，地址，价格，联系电话)

CREATE TABLE t_dingdan(did number(20) primary key,
                        dstatus varchar(10),
                        dperson varchar(10),
                        daddress varchar(100),
                        dprice number(20),
                        dphone number(20)); 

--    创建一张订单明细表，字段有(编号 主键，商品编号，价格，订单编号(外键))

CREATE TABLE t_ddetailed(ddid number(20) primary key,
ddgoodsid varchar2(50),
ddprice number(20),
dingd_id number(20),
constraint dingd_id_FK foreign key(dingd_id) references t_dingdan(did) on delete cascade);

--     1)、向订单表使用语句插入以下三条数据



--    (订单号:201403081201,订单状态：00,订货人:张三,地址：成都，价格：250，联系电话:13800138000)

INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081201,'00','张三','成都',250,13800138000)


--    (订单号:201403081202,订单状态：02,订货人:李四,地址：云南，价格：35，联系电话:10086)
INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081202,'02','李四','云南',35,10086)

--    (订单号:201403081203,订单状态：02,订货人:张三疯,地址：武当山，价格：800，联系电话:1008611)
INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081203,'02','张三疯','武当山',800,1008611)

--     2)、向订单明细表中插入以下5条数据
--     (编号：2014030801，商品编号：001,价格：200，订单编号：201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030801,'001',200,201403081203)


SELECT * FROM  t_ddetailed

--     (编号：2014030802，商品编号：003,价格：300，订单编号：201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030802,'003',300,201403081203)

--     (编号：2014030803，商品编号：004,价格：300，订单编号：201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030803,'004',300,201403081203)

--     (编号：2014030804，商品编号：005,价格：35，订单编号：201403081202)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030804,'005',35,201403081202)

--     (编号：2014030805，商品编号：002,价格：250，订单编号：201403081201)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030805,'002',250,201403081201)

--   3)、统计出20140308这天一共的销售额

SELECT sum(ddprice)
FROM t_ddetailed


--   4)、更新张三疯的地址为光明顶

UPDATE t_dingdan SET daddress='光明顶'
WHERE dperson='张三疯'

SELECT * FROM t_dingdan
SELECT * FROM t_ddetailed
--   5)、统计每种订单状态的价格总和
SELECT sum(ddprice)
FROM t_ddetailed
GROUP BY dingd_id


--   6)、在订单表中删除订单编号为201403081203的订单


DELETE FROM t_dingdan 
WHERE did=201403081203

--   7)、清空订单表
TRUNCATE TABLE t_ddetailed

TRUNCATE TABLE t_dingdan

--37、常见的数据库对象有哪些？约束有哪些?主键与唯一键的区别？
答:  表 ,视图,序列,索引,同义词
    2.not null ,unique ,primary key,foreign key,check
    3.主键的值唯一且不能有空值,而唯一键的值唯一但可以有空值

--38、表设计的三大范式？表之间的关系，各举一例？创建一张t_order表的备份表
答:
    1表中的列不可再分,在满足第一范式的基础上,表中的非主键列必须依赖主键列,在慢足第二范式的基础上,
    非主键列必须相互独立
    2.一对一,一对多与多对一 ,多对多
    3.CREATE TABLE t_order_bak
      AS
      SELECT * FROM t_order

--39、常见的分组函数有哪些?
答:
   1.sum() ,min(),max(),count(),avg()

--40、如何显示表结构？如何去掉重复行？sql语句分类，并指出各类语句下都有什么命令？
答:desc 表名
       2.SELECT distinct 列名 FROM 表名
       3.sql语句主要分为 增 ,删 ,改 ,查 四类
       增 :主要是 insert into 命令 
       删 :主要是 delete ,drop ,truncate 命令
       改 :主要是 update 命令
       查 :主要是 select 命令

--41、delete,truncate,drop区别？
答:
  1.delete是删除表行数据,同时有事务可以回滚
  2.truncate是清空表数据,但保留表结构
  3.drop是清空表数据,同时也将该表彻底删掉

--
  
