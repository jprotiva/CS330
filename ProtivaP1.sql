--  Name:   J.D. Protiva	
--  you can put other comments here if you so desire

use employees

select 'running query for problem 1, results:' as '=============================';
--  select count(*) from employees where first_name = 'hugo' and last_name = 'peng';

select 'running query for problem 2, results:' as '=============================';
-- select count(*) from employees where hire_date > '1995-1-1'; 

select 'running query for problem 3, results:' as '=============================';
--  select count(*) from employees where hire_date >= '1995-1-1';

select 'running query for problem 4, results:' as '=============================';
-- select count(*) from dept_emp where dept_no ='d002' and from_date >= '1980-1-1' and to_date <= '1985-12-31';

select 'running query for problem 5, results:' as '=============================';
--  select count(*) from titles where title ='manager';

select 'running query for problem 6, results:' as '=============================';
--  select count(*) from employees where last_name like '%good';


select 'running query for problem 7, results:' as '=============================';
--  select count(*) from employees where last_name like 'm%good';


select 'running query for problem 8, results:' as '=============================';
--  select from_date from employees e, titles t where e.emp_no = t.emp_no and e.first_name = 'yuchang' and e.last_name = 'weedman' and t.title = 'manager';

select 'running query for problem 9, results:' as '=============================';
--  select title from employees e, titles t where e.emp_no = t.emp_no and e.first_name = 'yuchang' and e.last_name = 'weedman' and from_date < (select t.from_date from employees e, titles t where e.emp_no = t.emp_no and e.first_name = 'yuchang' and e.last_name = 'weedman' and title = 'manager');


select 'running query for problem 10, results:' as '=============================';
--  select count(*) from salaries where salary > '150000';


select 'running query for problem 11, results:' as '=============================';
--  select count(*) from employees e, salaries s where e.emp_no = s.emp_no and  e.first_name='Lidong' and e.last_name='meriste';


select 'running query for problem 12, results:' as '=============================';
--  select first_name,last_name,salary from employees e, salaries s where e.emp_no=s.emp_no and s.salary =(select max(salary) from salaries);


select 'running query for problem 13, results:' as '=============================';
--  select first_name,last_name,salary from employees e, salaries s where e.emp_no=s.emp_no and s.salary =(select min(salary) from salaries);

select 'running query for problem 14, results:' as '=============================';
--  select first_name,last_name,salary from employees e, salaries s where e.emp_no=s.emp_no and s.salary =(select min(salary) from employees e, salaries s where e.emp_no=s.emp_no and gender = 'F');

select 'running query for problem 15, results:' as '=============================';
--  Put your query for problem 15 here
