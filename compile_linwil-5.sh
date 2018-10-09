echo "Compiling code..."
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImpl.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplJan2016.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplFeb2016.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplMar2016.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplApr2016.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplMay2016.java
javac -d ./bin -cp ./src ./src/ltu/Main.java ./src/ltu/CalendarImplJun2016.java
echo "Compiling tests..."
javac -d ./bin -cp ./lib/org.junit4-4.3.1.jar:./src ./src/ltu/PaymentTest.java