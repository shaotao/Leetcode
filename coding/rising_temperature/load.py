#!/usr/bin/python

import io
import sys
import os
import MySQLdb
import simplejson


if(len(sys.argv) != 2):
    print "usage: ./load.py <input.json>"
    sys.exit(0);

db = MySQLdb.connect(host="localhost", user="leetcode", port=3306, db="leetcode");


# remove old data
db.query("""delete from Weather""");

# insert new data
inputfile = open(sys.argv[1], 'r');
data = inputfile.read();
obj = simplejson.loads(data);
rows = obj["rows"]["Weather"];

for row in rows:
    cmd = "insert into Weather values ("+str(row[0])+", \""+row[1]+"\", "+str(row[2])+")";
    db.query(cmd);

db.commit();
db.close();
