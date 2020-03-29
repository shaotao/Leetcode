use leetcode;
select t.Name as Customers from (select c.Name as Name, o.CustomerId as CustomerId from Customers c left join Orders o on c.Id = o.CustomerId) as t where isnull(t.CustomerId);
