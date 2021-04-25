DECLARE

cursor c1 is select cust_id,dop,status from cust13 where cust_id='&cust_id';
paid exception;
notfound exception;
D cust13.dop%type;
status cust13.status%type;
id cust13.cust_id%type;
days int;
amt int;

BEGIN

open c1;
fetch c1 into id,D,status;
if( c1%NOTFOUND ) then
raise notfound;

elsif status='paid' then
raise paid;


elsif( status='not_paid' ) then
days:=sysdate-D;

if( days>15 and days<30 ) then
amt:=days*5;

elsif( days>30 ) then
amt:=days*50;

elsif( days<30 ) then
amt:=days*5;
 end if;
 
 
end if;
insert into fine13 values(id,D,amt);
 update cust13 set status='p' where cust_id=id;
 
close c1;

EXCEPTION
WHEN paid then 
dbms_output.put_line('Already paid');
when notfound then
dbms_output.put_line('Not found');

END;
/

