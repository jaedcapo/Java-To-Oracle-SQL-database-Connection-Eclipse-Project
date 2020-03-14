create or replace procedure update_emp(
    enumber in number,
    empname in varchar2,
    jobname in varchar2,
    managernumb in number,
    hdate in date,
    salary in number,
    commision in number,
    depto in number
)

is

begin

    update emp 
    set

    ename = empname, 
    job = jobname, 
    mgr = managernumb, 
    hiredate = hdate, 
    sal = salary, 
    comm = commision, 
    deptno = depto

    where empno = enumber;

end;