#!/bin/bash
echo "Компиляция..."

rm -rf out
mkdir -p out

javac -encoding UTF-8 -d out Main.java numbers/*.java strings/*.java arrays/*.java util/*.java

if [ $? -ne 0 ]; then
    echo "ошибка компиляции!"
    exit 1
fi

echo "создание jar..."
jar cfm lab2.jar manifest.mf -C out .

if [ $? -ne 0 ]; then
    echo "ошибка создания jar!"
    exit 1
fi

echo "готово! запустите: java -jar lab2.jar"
