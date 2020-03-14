create or replace procedure delete_emp(
    numero in number
)
is begin
    delete from emp where empno = numero;
    commit;
    end;