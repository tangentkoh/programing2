#!/bin/sh
## 課題３のスクリプト

for i in 005 015 025
do
    input_file="graph/graph${i}.txt"
    
    echo "graph${i}.txtの経路と経路長:"

    java DFSTester $input_file 150 250
    echo ""
done
