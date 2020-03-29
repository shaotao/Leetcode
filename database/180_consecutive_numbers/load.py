#!/usr/bin/python

import io
import sys
import os
import MySQLdb
import simplejson


if(len(sys.argv) != 2):
    print "usage: ./load.py input.dat"
    sys.exit(0);

db = MySQLdb.connect(host="localhost", user="leetcode", port=3306, db="leetcode");

# drop the table if it exists
db.query("DROP TABLE IF EXISTS Logs;");

db.query("CREATE TABLE Logs (Id int, Num int);");

# remove old data
db.query("""delete from Logs""");

# insert new data
inputfile = open(sys.argv[1], 'r');
for line in inputfile:
    items = line.split(' ');
    cmd = "insert into Logs values ("+items[0]+", "+items[1]+")";
    db.query(cmd);

inputfile.close();

db.commit();
db.close();
