use leetcode;
select a.Name from Employees a, Employees b where a.Salary > b.Salary and a.ManagerId = b.Id;
