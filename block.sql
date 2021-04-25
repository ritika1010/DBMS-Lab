DECLARE

cursor c1 is select Cust_id,DOP,status from CustomerS where Cust_id='&Cust_id' and scheme='&scheme';
paid exception;
notfound exception;
dop CustomerS.DOP%type;
status CustomerS.status%type;
id CustomerS.Cust_id%type;
days int;
amt int;

BEGIN

open c1;
fetch c1 into id,dop,status;
if( c1%NOTFOUND ) then
raise notfound;

elsif status='paid' then
raise paid;


elsif( status='not_paid' ) then
days:=sysdate-dop;

if( days>15 and days<30 ) then
amt:=days*5;

elsif( days>30 ) then
amt:=days*50;

elsif( days<30 ) then
amt:=days*5;
 end if;
 
 insert into Fine values(id,dop,amt);
 update CustomerS set status='paid' where Cust_id=id;
 
end if;

close c1;

EXCEPTION
WHEN paid then 
dbms_output.put_line('Already paid');
when notfound then
dbms_output.put_line('Not found');

END;
/
