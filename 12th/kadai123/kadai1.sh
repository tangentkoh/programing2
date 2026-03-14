#!/bin/sh
# 課題１の内容を記述せよ

for i in $(seq -w 001 030)
do
    input_file="graph/graph${i}.txt"
    output_file="output/out${i}.txt"
    java GraphTester $input_file > $output_file
    diff $input_file $output_file > /dev/null
done
