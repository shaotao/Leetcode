#!/bin/bash

declare -A my_map

while read line;
do
    words=( $line )
    for word in ${words[@]};
    do
        my_map[$word]=$(( ${my_map[$word]} + 1))
    done
done < words.txt

# print the my_map by the keys
for key in ${!my_map[@]};
do
    printf "%s %d\n" $key ${my_map[$key]}
done | sort -k 2,2 -n -r
