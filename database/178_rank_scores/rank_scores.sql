select Scores.Score, my_rank.Rank from Scores, (select Score, @n := @n+1 Rank from (select distinct Score from Scores order by Score desc) as t, (select @n:=0) m) as my_rank where Scores.Score = my_rank.Score order by Scores.Score desc;
