use leetcode;

# the slow way:
#select DISTINCT Num as ConsecutiveNums from Logs as t1 where t1.Num = (select Num from Logs as t2 where t2.Id = t1.Id+1) and t1.Num = (select Num from Logs as t3 where t3.Id = t1.Id+2);

# the fast way:
select DISTINCT a.Num as ConsecutiveNums from Logs a, Logs b, Logs c where b.Id = a.Id+1 and c.Id = a.Id+2 and a.Num = b.Num and a.Num = c.Num;
