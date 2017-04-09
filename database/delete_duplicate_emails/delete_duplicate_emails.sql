use leetcode;
#select * from Person2 a where (select count(*) from Person2 b where a.Id > b.Id and a.Email = b.Email) = 0;

delete from a using Person2 a inner join Person2 b where a.Id > b.Id and a.Email = b.Email;
