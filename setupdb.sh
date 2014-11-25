# Change the USERNAME and PASSWORD of your local MySQL installation here. This
# script will automatically create the java mysql user and tables required to
# run the project.
USERNAME=root
PASSWORD=""

######

DATABASENAME=311project
# Create Database and User
mysql -u ${USERNAME} --password="${PASSWORD}" < sql/setupdb.sql

# Create tables.
mysql -u ${USERNAME} --password="${PASSWORD}" ${DATABASENAME} < sql/create-tables.sql
