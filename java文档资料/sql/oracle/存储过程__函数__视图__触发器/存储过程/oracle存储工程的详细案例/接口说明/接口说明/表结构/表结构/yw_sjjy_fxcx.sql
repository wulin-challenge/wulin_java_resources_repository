----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:59:38 --
----------------------------------------------------

set define off
spool yw_sjjy_fxcx.log

prompt
prompt Creating table YW_SJJY_FXCX
prompt ===========================
prompt
create table YW_SJJY_FXCX
(
  id      CHAR(32) not null,
  grbm    VARCHAR2(20) not null,
  cxbm    VARCHAR2(100) not null,
  sjzt    CHAR(1),
  cxsj    DATE default sysdate,
  clsj    DATE,
  dqbm    CHAR(6),
  jhlsh   CHAR(32),
  mbbm    NUMBER,
  cszt    CHAR(1),
  jhbm    VARCHAR2(10),
  tqzt    CHAR(1),
  tqsj    DATE,
  nplanid CHAR(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_SJJY_FXCX
  is '数据交换表（反向和计划）';
comment on column YW_SJJY_FXCX.id
  is '维护ID';
comment on column YW_SJJY_FXCX.grbm
  is '个人编码';
comment on column YW_SJJY_FXCX.cxbm
  is '查询编码，如果是计划数据，CXBM为0';
comment on column YW_SJJY_FXCX.sjzt
  is '数据状态（0：银海未处理，1银海已处理）';
comment on column YW_SJJY_FXCX.cxsj
  is '参保用户查询时间，或计划数据插入时间';
comment on column YW_SJJY_FXCX.clsj
  is '生产方（银海）数据处理时间';
comment on column YW_SJJY_FXCX.dqbm
  is '地区编码';
comment on column YW_SJJY_FXCX.jhlsh
  is '数据交换批次流水号';
comment on column YW_SJJY_FXCX.mbbm
  is '模板编码';
comment on column YW_SJJY_FXCX.cszt
  is '数据状态
4:准备抽取
0:未传输
1:传输中
2:传输成功
3:传输失败';
comment on column YW_SJJY_FXCX.jhbm
  is '计划编码，关联YW_DX_DXJH
如果为计划数据，则为计划编码
如果是反向查询数据则为2
';


spool off
