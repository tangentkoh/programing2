#!/bin/sh
# バッチ処理用のシェルスクリプトを作成する
mkdir -p output

for i in $(seq -w 1 30)
do
    java KP input/$i.txt > output/$i.txt
done

echo "All files processed."
