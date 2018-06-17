/*
185. Department Top Three Salaries
DescriptionHintsSubmissionsDiscussSolution

SQL Schema
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int)
Create table If Not Exists Department (Id int, Name varchar(255))
Truncate table Employee
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1')
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2')
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2')
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1')
Truncate table Department
insert into Department (Id, Name) values ('1', 'IT')
insert into Department (Id, Name) values ('2', 'Sales')

The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+
*/

/*
Get the 3rd highest salary in each department
*/
SELECT DISTINCT stadium.id, stadium.date, stadium.people 
FROM stadium, (SELECT S1.id AS id1, S1.date date1, S1.people people1, 
	                  S2.id AS id2, S2.date date2, S2.people people2, 
					  S3.id AS id3, S3.date date3, S3.people people3 
			   FROM stadium S1 JOIN stadium S2 ON S2.id = S1.id+1
                               JOIN stadium S3 on S3.id = S1.id+2
               WHERE S1.people >= 100 AND S2.people >= 100 AND S3.people >= 100) T 
WHERE (stadium.id = T.id1 AND stadium.date = T.date1) OR 
      (stadium.id = T.id2 AND stadium.date = T.date2) OR 
	  (stadium.id = T.id3 AND stadium.date = T.date3);

