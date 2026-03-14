#!/bin/sh
## 課題２のスクリプト

for i in 010 020 030
do
    input_file="graph/graph${i}.txt"
    
    echo "graph${i}.txtの最短経路と経路長:"

    java BFSTester $input_file 0 200 

    echo ""
done
