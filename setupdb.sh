# Change the USERNAME and PASSWORD of your local MySQL installation here. This
# script will automatically create the java mysql user and tables required to
# run the project.
USERNAME=root
PASSWORD=""

######
DATABASENAME=311project
JAVAUSER="java@localhost"
JAVAUSERPASS="311projectpassword"

# Create Database
echo "DROP DATABASE IF EXISTS ${DATABASENAME}" | mysql -u ${USERNAME} --password="${PASSWORD}"
echo "CREATE DATABASE ${DATABASENAME}" | mysql -u ${USERNAME} --password="${PASSWORD}"

# Create Java User
echo "DROP USER '${JAVAUSER}'" | mysql -u ${USERNAME} --password="${PASSWORD}"
echo "CREATE USER '${JAVAUSER}' IDENTIFIED BY '${JAVAUSERPASS}'" | mysql -u ${USERNAME} --password="${PASSWORD}"
echo "GRANT ALL PRIVILEGES ON *.* TO '${JAVAUSER}' IDENTIFIED BY '${JAVAUSERPASS}' WITH GRANT OPTION" | mysql -u ${USERNAME} --password="${PASSWORD}"

# Create tables.
mysql -u ${USERNAME} --password="${PASSWORD}" ${DATABASENAME} < src/project/database/create-tables.sql
