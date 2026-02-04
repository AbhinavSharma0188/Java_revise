@echo off
echo Commpiling and Running OOPS...
javac OOPS\another.java OOPS\Student.java
if %errorlevel% equ 0 (
    java OOPS.another
) else (
    echo Compilation failed!
)
