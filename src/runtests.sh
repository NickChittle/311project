javac -d ../bin -cp .:/usr/share/java/junit4.jar tests/*.java

java -cp ../bin:/usr/share/java/junit4.jar:../lib/mysql-connector-java-5.1.33-bin.jar org.junit.runner.JUnitCore tests.TaxManagerTest
