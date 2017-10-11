----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:59:57 --
----------------------------------------------------

set define off
spool yw_dx_grjc.log

prompt
prompt Creating table YW_DX_GRJC
prompt =========================
prompt
create table YW_DX_GRJC
(
  dwbm  VARCHAR2(10),
  grbm  VARCHAR2(20) not null,
  sfzh  VARCHAR2(18),
  xm    VARCHAR2(15),
  ryzt  VARCHAR2(5),
  gwybz VARCHAR2(5),
  xb    VARCHAR2(2),
  bz    VARCHAR2(500),
  dqbm  CHAR(6),
  dhhm  VARCHAR2(50),
  yys   VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 24M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_DX_GRJC
  is '个人基础信息表';
comment on column YW_DX_GRJC.dwbm
  is '单位编码';
comment on column YW_DX_GRJC.grbm
  is '主键，个人编码';
comment on column YW_DX_GRJC.sfzh
  is '身份证';
comment on column YW_DX_GRJC.xm
  is '姓名';
comment on column YW_DX_GRJC.ryzt
  is '人员状态(标志是否做了逻辑删除)';
comment on column YW_DX_GRJC.gwybz
  is '公务员标志（1：公务员，0：非公务员）';
comment on column YW_DX_GRJC.xb
  is '性别（1：男，2：女）';
comment on column YW_DX_GRJC.bz
  is '备注';
comment on column YW_DX_GRJC.dqbm
  is '地区编码，关联YW_DQ';
comment on column YW_DX_GRJC.dhhm
  is '电话号码';
comment on column YW_DX_GRJC.yys
  is '运营商';
alter table YW_DX_GRJC
  add constraint PK_YW_GRJC primary key (GRBM)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 8M
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
