#!/bin/bash

num=0;

while read line;
do
    num=$(($num+1));
    if [[ $num -eq 10 ]]
    then
        echo "$line"
    fi
done < file.txt
