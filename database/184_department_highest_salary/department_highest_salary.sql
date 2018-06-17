use leetcode;
select d.Name as Department, e.Name, e.Salary from Employee_dept e, Department d, (select e.Name, max(e.Salary) as Salary, e.DepartmentId from Employee_dept e group by e.DepartmentId) t where d.id = t.DepartmentId and e.Salary = t.Salary and e.DepartmentId = t.DepartmentId;
