----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:58:55 --
----------------------------------------------------

set define off
spool yw_sjjy.log

prompt
prompt Creating table YW_SJJY
prompt ======================
prompt
create table YW_SJJY
(
  id         CHAR(32) not null,
  grbm       VARCHAR2(20) not null,
  dqbm       CHAR(6) not null,
  sjzt       CHAR(1),
  sjlx       VARCHAR2(10),
  mbbm       NUMBER,
  sjlr       CLOB not null,
  jhlsh      CHAR(32),
  cszt       CHAR(1),
  jhbm       VARCHAR2(10),
  inserttime DATE default sysdate,
  nplanid    CHAR(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 160M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_SJJY
  is '数据交换表（正向）';
comment on column YW_SJJY.id
  is '维护ID';
comment on column YW_SJJY.grbm
  is '个人编码';
comment on column YW_SJJY.dqbm
  is '地区编码';
comment on column YW_SJJY.sjzt
  is '数据状态（0：银海未处理，1银海已处理）';
comment on column YW_SJJY.sjlx
  is '数据类型(1:正向数据，2：反向查询的数据)';
comment on column YW_SJJY.mbbm
  is '模版编码，与模板表YW_DX_MB关联';
comment on column YW_SJJY.sjlr
  is '内容，XML拼接的数据';
comment on column YW_SJJY.jhlsh
  is '数据交换批次流水号，GUID';
comment on column YW_SJJY.cszt
  is '数据状态
4:准备抽取
0:未传输
1:传输中
2:传输成功
3:传输失败';
comment on column YW_SJJY.jhbm
  is '计划编码，与短信计划表YW_DX_DXJH关联';
create index IDX_YW_SJJY on YW_SJJY (ID)
  tablespace MZH
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_YW_SJJY_NPLANID on YW_SJJY (NPLANID)
  tablespace MZH
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
