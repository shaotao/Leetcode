select t1.Id from Weather as t1, Weather as t2 where to_days(t1.Date) = to_days(t2.Date)+1 and t1.Temperature > t2.Temperature;
