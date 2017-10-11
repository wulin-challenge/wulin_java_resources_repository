----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 16:00:26 --
----------------------------------------------------

set define off
spool yw_dm_dwxx.log

prompt
prompt Creating table YW_DM_DWXX
prompt =========================
prompt
create table YW_DM_DWXX
(
  dwbm VARCHAR2(10) not null,
  dwmc VARCHAR2(80),
  dwyx VARCHAR2(10),
  dqbm CHAR(6),
  grbm VARCHAR2(20)
)
tablespace MZH
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );


spool off
