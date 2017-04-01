Email Tamer to get access to MS SQL server (Send your group name)
	- You will recieve IP, port number, DB name, username, and password as response

*You can find all these software by searching on google
Download & Install:
	1. JAVA JDK
	2. Android Studio Bundle (Includes SDK)
	3. MS SQL Server Management Studio
	4. JTDS JDBC Driver (just download, should be a zip file)
		a. Extract this zip file somewhere (we will need the JTDS jar file from it later on)


NOTE: The provided project won't run unless you enter sql server information in the MainActivity.java file provided

1. Read Android Studio Setup file provided
2. MS SQL Setup
	a. Connect to the SQL server using the credentials provided
	b. Under your database folder, you can right click on tables -> Table... 	
		1. This will allow you to create new tables
		2. When you save this table, it'll ask you to name it
		3. When you refresh your tables in the Object Explorer window, it should show up there
			Note: If you named your table "Temp", it'll show up as "dbo.temp", you will need to use this new name
				to access the table

Go through the android code files provided to get the code for connecting to the sql server, also a sample query is provided




Note: If you want to run your program on your phone, Enable USB debugging on your phone (it should be in your phone settings),
then connect your phone. Your phone should show up as an option when you try to run your application in android
studio


Helpful Websites::

w3schools.com
tutorialspoint.com
google.com
youtube.com