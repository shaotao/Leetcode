/*
626. Exchange Seats
DescriptionHintsSubmissionsDiscussSolution

SQL Schema
Create table If Not Exists seat(id int, student varchar(255))
Truncate table seat
insert into seat (id, student) values ('1', 'Abbot')
insert into seat (id, student) values ('2', 'Doris')
insert into seat (id, student) values ('3', 'Emerson')
insert into seat (id, student) values ('4', 'Green')
insert into seat (id, student) values ('5', 'Jeames')

Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.

The column id is continuous increment.
Mary wants to change seats for the adjacent students.
Can you write a SQL query to output the result for Mary?
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
For the sample input, the output is:
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
Note:
If the number of students is odd, there is no need to change the last one's seat.
*/
SELECT (CASE WHEN (id%2=1 AND id=(SELECT MAX(id) FROM seat)) THEN id WHEN id%2=1 THEN id+1 ELSE id-1 END) as id, student FROM seat ORDER BY id;
