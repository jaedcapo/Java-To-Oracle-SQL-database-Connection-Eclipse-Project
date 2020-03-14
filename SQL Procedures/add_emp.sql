create or replace procedure add_emp(
    empno in number,
    ename in varchar2,
    job in varchar2,
    mgr in number,
    hiredate in date,
    sal in number,
    comm in number,
    deptno in number
)

is

begin

    insert into emp values(empno, ename, job, mgr, hiredate, sal, comm, deptno);
    commit;
end;