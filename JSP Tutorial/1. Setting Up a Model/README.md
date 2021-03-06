# Setting Up A Model
## Table of contents
1. [Creating a model](#Creating-a-model)
2. [Create product method](#Create-product-method)
3. [Testing the model through main](#Testing-the-model-through-main)
4. [Update and delete](#Update-and-delete)
5. [Querying](#Querying)

## Creating a model
To create a model, go to Source Packages and right click the package, select **new > Java Class**, then input the name of the class. In this example we will go for Product.

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Setting%20Model%201.png)

The Product.java should be present under the user desired package name. When creating a java class, there is already a template written for you with a bit of  documentation. Now the properties of the Product object data types **SHOULD MATCH** the fields present on the product table such as the name and the data. For example if the productID is int in mysql, it should also be int in java.

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Setting%20Model%202.png)
![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Setting%20Model%203.png)

**_Note: There are cases where the data types in mysql and java sometimes do not match. Be careful! Make sure to double check your data types! These can cause an error later!_**

**_FAQ: You can use public or private it is up to you. For the date, we will be using java.sql.Date since java.util.Date is not converted to java.sql.Date. You can also make a constructor instead of directly assigning the values manually, up to you! Variable names may vary as well but it is a good programming practice to match the variable name with the field name!_**

Now let us create a method in mysql in the Product class. __You are *REQUIRED* to import the java.sql.*__.

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Setting%20Model%204.png)

**Note: I created a boolean error and string errorMsg variable in case for JSP or for java testing. However if you are confident with your code, it is optional.**

## Create product method
Let us describe the code in order:
1. `Class.forName(“com.mysql.jdbc.Driver”).newInstance();` - You are creating a new driver instance specifying that the database you are to use is MySQL.

2. `connection = DriverManager.getConnection()` - You are telling the driver to establish a connection with the database. The method requires a string parameter. We will discuss the content of the string `"jdbc:mysql://localhost:3307/wintermelon?useSSL=false&useTimezone=true&serverTimezone=Asia/Singapore&user=root&password=p@ssword"`
   - `jdbc:mysql://localhost` is constant. You don’t have to worry about it. However if it is an actual db deployed, you can change the localhost to the ip address.
   - `3307` is the port number, you may be required to change this depending on the port your professor told you.
   - `wintermelon` - this is the name of my schema in mysql. Take note you have to match this to your corresponding schema/db name or else the connection will fail.
   - The following after `?` are query parameters of the url `&` is used to append query parameters to the jdbc link.
     - The `useSSL` is for communicating with the mysql database using SSL. You can set this to true or false but for now it is recommended to set it to false first.
     - `useTimezone = true`. (optional) This allows the jdbc to ensure that you will be using a timezone
     - `serverTimezone = Asia/Singapore`. (optional) You specified that the serverTimezone is using Asia/Singapore. Take note if you do not specify this, the timezone is by default UTC+8, which may affect the data you receive when trying to add date or time via jsp. You can change this depending on the timezone you want but make sure to read the documentation for the available timezones.
     - `user = root`. **(important)** You can change the root if your database username is different. 
     - `password = p@ssword`. **(important)** You can change this if your password on mysql is different.

**_Note:  You may be required to change the username and password and port number if submitting to the professor!_**

3. `statement = connection.prepareStatement()` - This command allows you to insert mysql statements. Take note of the mysql statement: `INSERT INTO products (productID, name, dateCreated, quantity) VALUES(?, ?, ?, ?)` If you are wondering about the symbol `?`, it means data will be appended to the statement. Data can be appended via the methods following after it

4. `statement.setInt(1, productID)` - this function tells us that you are specifying that you will append the **1st** `?` with an integer type and the value being appended is the `productID`. It is recommended that you write the code in order of the `?` so that confusion is minimal. 

**Note that the data type of the variable should match the method Java will tell you an error if the method and data type does not match. For more methods of the prepare statement please read the [API](https://docs.oracle.com/javase/8/docs/api/index.html?java/sql/package-summary.html).**

5. `statement.execute()` - This function allows you to execute the statement from #3. Note that this is only recommended if you are using Insert, Update and Delete operations. It would be a **different** case for querying as you will use `statement.executeQuery()`.

6. `statement.close()` and `connection.close()` - This is just to close the connection after we are done with the execution of the statement

**Note: Once that the model is created it is recommended to [check the methods](#Testing-the-model-through-main) first before actually implementing it on JSP. This is because if you do not check the java methods, your limit of checking will range from java to jsp. Test the connection first. This can be done by making a main on your class.**

## Testing the model through main
![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Testing%20Model%201.png)

The `Date.valueOf()` method converts the string into a date!

**Note: It should be successful! You may see an error saying Loading class ‘com.mysql.jdbc.Driver’ is deprecated however you can ignore this. product.errorMsg is null if the program has not caught an error. Check the database to see whether or not the new product has been created!**

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Testing%20Model%202.png)

As you can see the product has been added to the database. 

If your product has not been added please check your code. Errors can be:
1. Wrong Syntax
2. Logical Error in the prepare Statement
3. Java to mysql connector has not been added to the library
4. Incorrect connection, make sure to match your mysql database schema and etc.

Now that you’ve learned the foundations of create, you can also do the [update and delete](#Update-and-delete) easily! You just have to change the statement!

## Update and delete
![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Update%20Model%201.png)

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Update%20Model%202.png)

**It should update the database!**

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Delete%20Model%201.png)

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Delete%20Model%202.png)

**The product can no longer be found anymore!**

## Querying
Now that you know how to create, delete and update, select is quite different from the other operations. Take note that in CUD, you only need to execute it (see the result in the database) however in querying, you want to get the data given to you. Now let’s try to populate our table a bit, you can use mysql for this or use the newly created methods:

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Querying%20Model%201.png)

Now that the data is populated let’s try to query the data:

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Querying%20Model%202.png)

As you can see, there are newly added things such as `ResultSet`, `ArrayList`, and a few other commands. Let’s try to break it down a bit:
1. `ResultSet rs` - This allows you to acquire the query from the `SELECT` statement
2. `rs = statement.executeQuery()` - This assigns the query to the rs
3. `while(rs.next())` - you see the value of `rs.next()` is the data from mysql, think of it as rows. If there is a value for the next row, continue on! Now the `rs.next()` does not automatically assign the data to the object, you have to do it manually!
4. `product.productID = rs.getInt(1)` - Similar to the CUD statement, the number determines the positioning. ***Note that the positioning is based on the mysql columns!*** If you want to check more on the methods available in `ResultSet` please check the [API](https://docs.oracle.com/javase/8/docs/api/index.html?java/sql/package-summary.html)!
5. `rs.close()` - closing of the `ResultSet` after it is done. Since we already added all the products to the `ArrayList`, we do not need the rs anymore therefore we could close it.

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Querying%20Model%203.png)

We will now output the contents of the ArrayList returned by the method. You may also create a `toString()` if you want to!

![](/JSP%20Tutorial/1.%20Setting%20Up%20A%20Model/images/Querying%20Model%204.png)

I hope you are able to get the same result as me! If you didn’t take note of the following:
1. **Positioning** of the fields in the mysql
3. Data Types should **match**!