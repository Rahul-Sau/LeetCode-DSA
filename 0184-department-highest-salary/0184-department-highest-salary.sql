# Write your MySQL query statement below
select dept.name as Department, emp.name AS Employee, emp.salary AS Salary
From Employee emp
join Department dept 
on emp.departmentId=dept.id
where emp.salary=(
    select MAX(salary)
    from Employee
    where departmentId=emp.departmentId
);