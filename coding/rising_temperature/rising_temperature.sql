use leetcode;
select Id from Weather as a where Temperature > (select Temperature from Weather as b where a.Date=b.Date+1);
