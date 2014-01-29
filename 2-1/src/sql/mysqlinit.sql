DROP DATABASE spring;
CREATE DATABASE spring CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON spring.* to springuser@localhost IDENTIFIED BY 'springpassword' WITH GRANT OPTION;
quit