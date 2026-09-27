@echo off
echo компиляция...

if exist out rmdir /s /q out
mkdir out

javac -encoding UTF-8 -d out Main.java numbers\*.java strings\*.java arrays\*.java util\*.java

if %ERRORLEVEL% NEQ 0 (
    echo ошибка компиляции!
    exit /b 1
)

echo создание jar...
jar cfm lab2.jar manifest.mf -C out .

if %ERRORLEVEL% NEQ 0 (
    echo ошибка создания jar!
    exit /b 1
)

echo готово! запустите: java -jar lab2.jar
