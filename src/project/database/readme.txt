To make the database work:

1) Install MySQL - If you change the port remember it, by default it's 3306.
2) The Driver for JDBC is in the lib directory. It can be downloaded from here:
http://dev.mysql.com/downloads/connector/j/
3) If you're using an IDE like Eclipse or Netbeans, then you can add it to the
classpath by adding the JAR file as Library to the Build Path in project's
properties.

If you're doing it "plain vanilla" in the command console, then you need to
specify the path to the JAR file in the -cp or -classpath argument when
executing your Java application.

// Run from the 'src/' directory.
java -cp .:../lib/mysql-connector-java-5.1.33-bin.jar Main


Create a now SQL User:
Username = 'java'
password = '311projectpassword'

CREATE USER 'java'@'localhost' IDENTIFIED BY '311projectpassword';
GRANT ALL PRIVILEGES ON *.* TO 'java'@'localhost' IDENTIFIED BY '311projectpassword' WITH GRANT OPTION;

Creating the tables.
mysql -u root --password="" 311project < create-tables.sql
