--所有接口
--------------------------------------------------------
--i_sp_sjjy_insert
--5.1 写入数据交换表
/*
存储过名称：i_sp_sjjy_insert（写入数据交换表）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，插入反向查询信息。  
*/
create or replace procedure i_sp_sjjy_insert(
ids in yw_sjjy.id%type,--id
grbms in yw_sjjy.grbm%type,--个人编码
dqbms in yw_sjjy.dqbm%type,--地区编码
mbbms in yw_sjjy.mbbm%type,--模板编码
sjlrs in yw_sjjy.sjlr%type,--数据内容（xml格式）
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)
is
sjlx varchar2(10);
npid raw(16);
begin
  if(ids is null)then
    --如果id为空，新产生一个sys_guid，并同传入的其他参数一起新增到数据交换表中
    insert into yw_sjjy(id,grbm,dqbm,sjzt,sjlx,mbbm,sjlr,jhlsh,cszt,jhbm,inserttime,nplanid)values
  (sys_guid,grbms,dqbms,'0','1',mbbms,sjlrs,null,'0','0',sysdate,null);
  elsif(ids is not null)then
    begin
      --id不为空时，到反向查询交换表中去查询对应的nplanid字段信息
      select y.nplanid into npid from yw_sjjy_fxcx y where y.id=ids;
      --id不为空时，到反向查询交换表中去jhbm字段信息
      select y.jhbm into sjlx from yw_sjjy_fxcx y where y.id=ids;
      --异常处理
    exception when no_data_found then
      npid:=null;
      sjlx:=null;
    end;
    --新增信息到数据交换表中
    insert into yw_sjjy(id,grbm,dqbm,sjzt,sjlx,mbbm,sjlr,jhlsh,cszt,jhbm,inserttime,nplanid)values
  (ids,grbms,dqbms,'0',sjlx,mbbms,sjlrs,null,'0','0',sysdate,npid);
  end if;
  results:=1;
  messages:=null;
  commit;
  --异常处理
  exception
    when others then
    rollback;
    results:=0;
    messages:=substr(sqlerrm,1,100);
end i_sp_sjjy_insert;
--------------------------------------------------------

--------------------------------------------------------
--测试
declare
id char(32):='9bde802016794972b4d0772ccb9ca214';
grbm varchar2(20):='888888888';
dqbm char(6):='555555';
mbbm number:='0';
sjlr clob:='<test></test>';
results number;
messages varchar(100);
begin
  i_sp_sjjy_insert(id,grbm,dqbm,mbbm,sjlr,results,messages);
  dbms_output.put_line('results'||results);
  dbms_output.put_line('messages'||messages);
end;
select * from yw_sjjy y where y.id='9bde802016794972b4d0772ccb9ca214' for update;
--------------------------------------------------------
--创建临时表，用于存放查询反向查询交换表后所查询的id
create global temporary table temp_id
(
       id char(32)
);
--i_sp_sjjy_fxcx_select
--5.2查询反向查询交换表
/*
存储过名称：i_sp_sjjy_fxcx_select（查询反向查询交换表）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，查询反向查询交换表。  
*/
create or replace procedure i_sp_sjjy_fxcx_select(
lens number,--要查询的行数
dqbms char,--地区编码
results out sys_refcursor--结果集
)is
begin
  --返回结果集
  open results for select y.id,y.grbm,y.cxbm,y.sjzt,y.cxsj,y.clsj,y.mbbm,y.cxbm from yw_sjjy_fxcx y where y.dqbm=dqbms and rownum<=lens and y.tqzt is null order by y.cxsj asc;
  --把返回结果集的id存入临时表temp_id中
  insert into temp_id select id from yw_sjjy_fxcx y where y.dqbm=dqbms and rownum<=lens and y.tqzt is null order by y.cxsj asc;
  --根据临时表中的id信息更新反向查询交换表中的提取状态字段
  update yw_sjjy_fxcx y set y.tqzt='1',y.tqsj=sysdate where y.id in (select id from temp_id);
  commit;
end;
--------------------------------------------------------
--以下测试要放在sql plus中进行
var x refcursor;
exec i_sp_sjjy_fxcx_select(2,'510100',:x);
print :x;
--------------------------------------------------------
select * from yw_sjjy_fxcx y for update;
--------------------------------------------------------
--i_sp_sjjy_update
--5.3 更新反向查询交换表
/*
存储过名称：i_sp_sjjy_update（更新反向查询交换表）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，更新反向查询交换表。  
*/
create or replace procedure i_sp_sjjy_update(
ids in yw_sjjy_fxcx.id%type,--id
sjzts in yw_sjjy_fxcx.sjzt%type,--数据状态
clsjs in yw_sjjy_fxcx.clsj%type,--处理时间
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
begin
  if(ids is null) then
    results:=0;
    messages:='id为空无法更新';
  elsif(ids is not null)then
    --更新反向查询交换表
    update yw_sjjy_fxcx y set y.sjzt=sjzts,y.clsj=clsjs where y.id=ids;
    results:=1;
    messages:=null;
    commit;
  end if;
  --异常处理
  exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);
end i_sp_sjjy_update;
--------------------------------------------------------
select * from yw_sjjy_fxcx;
--测试
declare id char(32):='7db6eca3ad4b4b008e1f8ecf72bf4784';
sjzt char(1):='0';
clsj date:=sysdate;
results number;
messages varchar2(100);
begin
  i_sp_sjjy_update(id,sjzt,clsj,results,messages);
  dbms_output.put_line(results);
  dbms_output.put_line(messages);
end;
-----------------------------------------------------------
--i_sp_grjc_insert
--5.4 新增参保人员
/*
存储过名称：i_sp_grjc_insert（新增个人基础信息）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，新增个人基础信息。  
*/
create or replace procedure i_sp_grjc_insert(
grbms in yw_dx_grjc.grbm%type,--个人编码
dwbms in yw_dx_grjc.dwbm%type,--单位编码
sfzhs in yw_dx_grjc.sfzh%type,--身份证号
xms in yw_dx_grjc.xm%type,--姓名
gwybzs in yw_dx_grjc.gwybz%type,--公务员标志
xbs in yw_dx_grjc.xb%type,--性别
dqbms in yw_dx_grjc.dqbm%type,--地区编码
dhhms in yw_dx_grjc.dhhm%type,--电话号码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
validityPhone varchar2(10);
isExistPhone number;
isExistGrbm number;
begin
  --判断电话号码是否合法
  --1，是否合法电话号码
  --2，是否重复
  validityPhone:=chargyys(dhhms);
  select count(*) into isExistPhone from yw_dx_grjc y where y.dhhm=dhhms and y.ryzt='1';
  --判断是否存在参保人员
  select count(*) into isExistGrbm from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms;
  if(validityPhone=0)then
     results:=0;
     messages:='电话号码不合法';
  else
     if(isExistPhone<>0)then
          results:=0;
          messages:='电话号码已存在';
     else
          if(isExistGrbm<>0)then
            results:=0;
            messages:='参保人个人编码已存在';
          else
            if(gwybzs not in('0','1','2','3','4'))then
              results:=0;
              messages:='人员标志不合法';
            else
              if(xbs not in('1','2'))then
                results:=0;
                messages:='性别不合法';
              else
                if(xms is null or (trim(dqbms) is null))then
                   results:=0;
                   messages:='姓名和地区编码都不能为空';
                else
                  begin
                   --新增个人基础信息
                   insert into yw_dx_grjc values(dwbms,grbms,sfzhs,xms,'1',gwybzs,xbs,'',dqbms,dhhms,chargyys(dhhms));
                   --新增操作信息到人员操作痕迹表中
                   --insert into yw_dx_grjcmark values(grbms,dqbms,1);
                   results:=1;
                   messages:=null;
                   commit;
                   --异常处理
                  exception
                   when others then
                    rollback;
                    results:=0;
                    messages:=substr(trim(sqlerrm),1,100);
                  end;
                end if;
              end if;
            end if;
          end if;
     end if;   
  end if;
end i_sp_grjc_insert;
-----------------------------------------------------------
--测试
declare
grbm varchar2(20):='100000000';
dwbm varchar2(10):='100000';
sfzh varchar2(18):='';
xm varchar2(15):='杨秀武';
gwybz varchar2(5):='4';
xb varchar2(2):='1';
dqbm char(6):='510100';
dhhm varchar2(11):='18100000002';
results number;
messages varchar2(100);
begin
  i_sp_grjc_insert(grbm,dwbm,sfzh,xm,gwybz,xb,dqbm,dhhm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dx_grjc y where y.grbm='100000000' for update;
-----------------------------------------------------------
--i_sp_grjc_update
--5.5 修改参保人员
/*
存储过名称：i_sp_grjc_update（修改个人基础表信息）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，修改个人基础表信息。  
*/
create or replace procedure i_sp_grjc_update(
grbms in yw_dx_grjc.grbm%type,--个人编码
dwbms in yw_dx_grjc.dwbm%type,--单位编码
sfzhs in yw_dx_grjc.sfzh%type,--身份证号
xms in yw_dx_grjc.xm%type,--姓名
ryzts in yw_dx_grjc.ryzt%type,--人员状态
gwybzs in yw_dx_grjc.gwybz%type,--公务员标志
xbs in yw_dx_grjc.xb%type,--性别
dqbms in yw_dx_grjc.dqbm%type,--地区编码
dhhms in yw_dx_grjc.dhhm%type,--电话号码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
validityPhone varchar2(10);
isExistPhone number;
isExistGrbm number;
begin
  --判断电话号码是否合法
  --1，是否合法电话号码
  --2，是否重复
  validityPhone:=chargyys(dhhms);
  select count(*) into isExistPhone from yw_dx_grjc y where y.dhhm=dhhms and y.ryzt='1' and y.grbm<>grbms;
  --判断是否存在参保人员
  select count(*) into isExistGrbm from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms;
  if(validityPhone=0)then
     results:=0;
     messages:='电话号码不合法';
  else
     if(isExistPhone<>0)then
          results:=0;
          messages:='电话号码已存在';
     else
          if(isExistGrbm=0 or (trim(dqbms) is null))then
            results:=0;
            messages:='参保人个人编码不存在或者地区编码为空';
          else
            if(gwybzs not in('0','1','2','3','4'))then
              results:=0;
              messages:='人员标志不合法';
            else
              if(xbs not in('1','2'))then
                results:=0;
                messages:='性别不合法';
              else
                if(xms is null or (ryzts not in('0','1')) )then
                   results:=0;
                   messages:='姓名不能为空或者人员状态有误';
                else
                  begin
                   --更新个人基础信息表
                   update yw_dx_grjc y set y.dwbm=dwbms,y.sfzh=sfzhs,y.xm=xms,y.ryzt=ryzts,y.gwybz=gwybzs,y.xb=xbs,y.dhhm=dhhms,y.yys=chargyys(dhhms) where y.grbm=grbms and y.dqbm=dqbms;
                   --新增操作信息到人员操作痕迹表中
                   insert into yw_dx_grjcmark values(grbms,dqbms,2);
                   results:=1;
                   messages:=null;
                   commit;
                   --异常处理
                  exception
                   when others then
                    rollback;
                    results:=0;
                    messages:=substr(trim(sqlerrm),1,100);
                  end;
                end if;
              end if;
            end if;
          end if;
     end if;   
  end if;
end i_sp_grjc_update;
-----------------------------------------------------------
--测试
declare
grbm varchar2(20):='100000005';
dwbm varchar2(10):='100000';
sfzh varchar2(18):='612326198604284511';
xm varchar2(15):='杨秀武';
ryzt varchar2(5):='0';
gwybz varchar2(5):='4';
xb varchar2(2):='1';
dqbm char(6):='510100';
dhhm varchar2(11):='15002817702';
results number;
messages varchar2(100);
begin
  i_sp_grjc_update(grbm,dwbm,sfzh,xm,ryzt,gwybz,xb,dqbm,dhhm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dx_grjc y where y.xm='杨秀武' for update;
select * from yw_dx_grjc y where y.grbm='100000005' for update;
-----------------------------------------------------------
--i_sp_grjc_delete
--5.6 删除参保人员
/*
存储过名称：i_sp_grjc_delete（修改基础人员状态）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，修改基础人员信息。  
*/
create or replace procedure i_sp_grjc_delete(
grbms in yw_dx_grjc.grbm%type,--个人编码
dqbms in yw_dx_grjc.dqbm%type,--地区编码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
isDelete number;
begin
  --根据个人编码，地区编码和人员状态判断是否存在人员信息
  select count(*) into isDelete from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms and y.ryzt='1';
  if(isDelete=0)then
     results:=0;
     messages:='人员已逻辑删除';
  else
    begin
      --修改个人基础表中人员状态信息
      update yw_dx_grjc y set y.ryzt='0' where y.grbm=grbms and y.dqbm=dqbms;
      --新增操作信息到人员操作痕迹表中
      insert into yw_dx_grjcmark values(grbms,dqbms,3);
      results:=1;
      messages:=null;
      commit;
      --异常处理
    exception
      when others then
       rollback;
        results:=0;
        messages:=substr(trim(sqlerrm),1,100);
    end;
  end if;
end i_sp_grjc_delete;
----------------------------------------------------------
select * from yw_dx_grjc y where y.xm='杨秀武';
--测试
declare grbm varchar2(20):='100000005';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_grjc_delete(grbm,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
----------------------------------------------------------
--i_sp_dwxx_insert
--5.7 新增单位
/*
存储过名称：i_sp_dwxx_insert（写入单位信息表）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，插入单位信息表。  
*/
create or replace procedure i_sp_dwxx_insert(
dwbms in yw_dm_dwxx.dwbm%type,--单位编码
dwmcs in yw_dm_dwxx.dwmc%type,--单位名称
dqbms in yw_dm_dwxx.dqbm%type,--地区编码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
isExist number;
begin
  --根据单位编码和地区编码判断是否存在单位信息
  select count(*) into isExist from yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  if(isExist=1)then
     results:=0;
     messages:='数据已存在';
  elsif(isExist=0)then
     --新增单位信息
     insert into yw_dm_dwxx(dwbm,dwmc,dwyx,dqbm,grbm)values(dwbms,dwmcs,'1',dqbms,'');
     --把所新增单位信息存入单位操作痕迹表
     --insert into yw_dm_dwxxmark values(dwbms,dqbms,1);
     results:=1;
     messages:=null;
     commit;
  end if;
  --异常处理
exception
  when others then
     rollback;
     results:=0;
     messages:=substr(trim(sqlerrm),1,100);
end i_sp_dwxx_insert;
----------------------------------------------------------
--测试
declare dwbm varchar2(10):='90022222';
dwmc varchar2(80):='异常人类研究所';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_insert(dwbm,dwmc,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dm_dwxx y where y.dwbm='90022222' and y.dqbm='510100' for update;
----------------------------------------------------------
--i_sp_dwxx_update
--5.8 修改单位
/*
存储过名称：i_sp_dwxx_update（修改单位信息表）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，修改单位信息。  
*/
create or replace procedure i_sp_dwxx_update(
dwbms in yw_dm_dwxx.dwbm%type,--单位编码
dwmcs in yw_dm_dwxx.dwmc%type,--单位名称
dqbms in yw_dm_dwxx.dqbm%type,--地区编码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
isExist number;
begin
  --以单位编码和地区编码为条件查询是否存在单位信息
  select count(*) into isExist from yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  if(isExist=0)then
      results:=0;
      messages:='数据不存在';
      --(dwbm,dwmc,dwyx,dqbm,grbm
  elsif(isExist=1)then
      --更新单位信息
      update yw_dm_dwxx y set y.dwmc=dwmcs where y.dwbm=dwbms and y.dqbm=dqbms;
      --把所更新单位信息存入单位操作痕迹表
    --  insert into yw_dm_dwxxmark values(dwbms,dqbms,2);
      results:=1;
      messages:=null;
      commit;
  end if;
  --异常处理
exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);  
end i_sp_dwxx_update;
----------------------------------------------------------
--测试
declare dwbm varchar2(10):='90022222';
dwmc varchar2(80):='非正常人类研究所';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_update(dwbm,dwmc,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
----------------------------------------------------------
--i_sp_dwxx_delete
--5.9 删除单位
/*
存储过名称：i_sp_dwxx_delete（删除单位信息）
创  建  人：杨秀武
创 建 日期：2017-07-29
功能 描 述：供外部生产方系统调用（如银海社保系统等）传入相应参数，删除单位信息。  
*/
create or replace procedure i_sp_dwxx_delete(
dwbms in yw_dm_dwxx.dwbm%type,--单位编码
dqbms in yw_dm_dwxx.dqbm%type,--地区编码
results out number,--执行结果（输出）
messages out varchar2--执行情况（输出）
)is
begin
  --根据传入参数删除单位信息
  delete yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  --把所删除单位信息存入单位操作痕迹表
  --insert into yw_dm_dwxxmark values(dwbms,dqbms,3);
  results:=1;
  messages:=null;
  commit;
  --异常处理
exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);
end i_sp_dwxx_delete;
----------------------------------------------------------
--测试
declare dwbm varchar2(10):='90022222';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_delete(dwbm,dqbm,results,messages);
end;
--
select * from yw_dm_dwxx y where y.dwbm='90022222' and y.dqbm='510100';
-----------------------------------------------------------
--授权
--1
grant execute on i_sp_sjjy_insert to interfaceuser;
grant select on yw_sjjy_fxcx to interfaceuser;
revoke select on yw_sjjy_fxcx from interfaceuser;
grant insert on yw_sjjy to interfaceuser;
revoke insert on yw_sjjy from interfaceuser;
--2
grant execute on i_sp_sjjy_fxcx_select to interfaceuser;
grant select on yw_sjjy_fxcx to interfaceuser;
revoke select on yw_sjjy_fxcx from interfaceuser;
grant insert on temp_id to interfaceuser;
revoke insert on temp_id from interfaceuser;
grant update on yw_sjjy_fxcx to interfaceuser;
revoke update on yw_sjjy_fxcx from interfaceuser;
--3
grant execute on i_sp_sjjy_update to interfaceuser;
grant update on yw_sjjy_fxcx to interfaceuser;
revoke update on yw_sjjy_fxcx from interfaceuser;
--4
grant execute on i_sp_grjc_insert to interfaceuser;
grant insert on yw_dx_grjc to interfaceuser;
revoke insert on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--5
grant execute on i_sp_grjc_update to interfaceuser;
grant select on yw_dx_grjc to interfaceuser;
revoke select on yw_dx_grjc from interfaceuser;
grant update on yw_dx_grjc to interfaceuser;
revoke update on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--6
grant execute on i_sp_grjc_delete to interfaceuser;
grant update on yw_dx_grjc to interfaceuser;
revoke update on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--7
grant execute on i_sp_dwxx_insert to interfaceuser;
grant select on yw_dm_dwxx to interfaceuser;
revoke select on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxx to interfaceuser;
revoke insert on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
--8
grant execute on i_sp_dwxx_update to interfaceuser;
grant select on yw_dm_dwxx to interfaceuser;
revoke select on yw_dm_dwxx from interfaceuser;
grant update on yw_dm_dwxx to interfaceuser;
revoke update on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
--9
grant execute on i_sp_dwxx_delete to interfaceuser;
grant delete on yw_dm_dwxx to interfaceuser;
revoke delete on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
