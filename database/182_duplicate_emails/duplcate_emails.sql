use leetcode;
select Email from (select Email, count(*) as count from Person group by Email) as a where a.count > 1;
