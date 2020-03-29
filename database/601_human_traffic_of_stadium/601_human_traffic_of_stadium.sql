/*
601. Human Traffic of Stadium
DescriptionHintsSubmissionsDiscussSolution

SQL Schema
Create table If Not Exists stadium (id int, date DATE NULL, people int)
Truncate table stadium
insert into stadium (id, date, people) values ('1', '2017-01-01', '10')
insert into stadium (id, date, people) values ('2', '2017-01-02', '109')
insert into stadium (id, date, people) values ('3', '2017-01-03', '150')
insert into stadium (id, date, people) values ('4', '2017-01-04', '99')
insert into stadium (id, date, people) values ('5', '2017-01-05', '145')
insert into stadium (id, date, people) values ('6', '2017-01-06', '1455')
insert into stadium (id, date, people) values ('7', '2017-01-07', '199')
insert into stadium (id, date, people) values ('8', '2017-01-08', '188')

X city built a new stadium, each day many people visit it and the stats are saved as these columns: id, date, people

Please write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).

For example, the table stadium:
+------+------------+-----------+
| id   | date       | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
For the sample data above, the output is:

+------+------------+-----------+
| id   | date       | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
Note:
Each day only have one row record, and the dates are increasing with id increasing.
*/

SELECT stadium.id, stadium.date, stadium.people FROM stadium, (SELECT S1.id AS id1, S1.date date1, S1.people people1, S2.id AS id2, S2.date date2, S2.people people2, S3.id AS id3, S3.date date3, S3.people people3
FROM stadium S1 
  JOIN stadium S2 ON S2.date = S1.date+1 
  JOIN stadium S3 on S3.date = S1.date+2 
WHERE S1.people > 100 AND S2.people > 100 AND S3.people > 100) WHERE (stadium.id = T.id1 AND stadium.date = T.date1) OR (stadium.id = T.id2 AND stadium.date = T.date2) OR (stadium.id = T.id3 AND stadium.date = T.date3);



