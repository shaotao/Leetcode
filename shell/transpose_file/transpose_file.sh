#!/bin/bash

declare -a data

nrow=0
ncol=0
while read line; do
	row=( $line )
	idx=0;
	ncol=${#row[@]}
	for item in ${row[@]}; do
		data[$(($nrow*$ncol+$idx))]=$item
		idx=$(($idx+1))
	done
	nrow=$(($nrow+1))
done <  file.txt

for (( idx_col=0; idx_col<ncol; idx_col++ ))
do
	for (( idx_row=0; idx_row<nrow; idx_row++ ))
	do
		printf "%s" ${data[$(($idx_row*$ncol+$idx_col))]}
		if [[ $idx_row -lt $(($nrow-1)) ]]; then
			printf " "
		fi
	done
	if [[ $idx_col -lt $(($ncol-1)) ]]; then
		printf "\n"
	fi
done
