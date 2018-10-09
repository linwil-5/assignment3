@echo off
set JDK_HOME=C:\PROGRA~1\Java\jdk1.8.0_111
@echo "Compiling code ..."
@mkdir bin
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImpl.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplJan2016.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplFeb2016.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplMar2016.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplApr2016.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplMay2016.java
%JDK_HOME%/bin/javac.exe -d bin -cp src src/ltu/Main.java src/ltu/CalendarImplJun2016.java
@echo "Compiling tests ..."
set JUNIT=C:\Users\William\Desktop\assignment3testing\lib\org.junit4-4.3.1.jar
%JDK_HOME%/bin/javac.exe -d bin -cp %JUNIT%;src src/ltu/PaymentTest.java