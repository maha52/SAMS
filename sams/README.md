+++++++++++++++++++++++++++++++++++++++
How to run
+++++++++++++++++++++++++++++++++++++
1. Open a terminal and run 
	mysql -u root -p
	create user sams identified by "samsp";
	create database sams ;
	grant all on sams.* to sams@localhost identified by "samsp";
	\. "path/to/sams.sql"
	exit

2. run the sams.jar file or
NB: Default username: admin
password: easy

3. Build your own version of sams in Netbeans
	++++++++++++++++++++++++++++++++++++
	Requirements
	++++++++++++++++++++++++++++++++++++
	1.	JDK8
	2. ADD MYSQL JDBC DRIVER TO CLASSPATH
	3. ADD ALL CONTENTS OF dist/lib/ to CLASSPATH
	4. Compile , run and be merry
++++++++++++++++++++++++++++++++++++++++++++++++
bwepngong@gmail.com
+++++++++++++++++++++++++++++++++++++++++++++++
