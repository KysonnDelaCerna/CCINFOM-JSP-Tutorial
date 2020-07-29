# JSP Tutorial

## Table of contents
- [What is JSP?](#What-is-JSP?)
- [Creating a JSP project in NetBeans](#Creating-a-JSP-project-in-NetBeans)
- [Installing JDBC](#Installing-JDBC)
- [MySQL connector jar download guide](#MySQL-connector-jar-download-guide)
- [Tomcat error guide](#Tomcat-error-guide)
0. [Sample Project](/JSP%20Tutorial/0.%20Sample%20Project)
1. [Setting Up a Model](/JSP%20Tutorial/1.%20Setting%20Up%20a%20Model)
2. [Making a JSP Web Page](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page)

## What is JSP?
JSP or **J**ava**S**erver **P**ages is a Java Standard Technology that allows you to write dynamic or data-driven pages for Java Web applications. By building on top of Java Servlet Specifications, it allows you to write java codes into HTML files. JSP also has access to powerful Enterprise Java APIs such as **JDBC (Java Database Connectivity)**, **JNDI**, etc.

![](/JSP%20Tutorial/images/JSP%20Sample.png)

One key benefit of JSP is that you can input java codes in HTML like the example above. In a standard HTML page, you cannot create variables as well as displaying the output of their content.

**Note:** JSP is a server side technology, meaning there is no way for you to view the actual web page using any browser. You would have to establish a client server relationship. When trying to access the jsp file, the client would have to make a request to the server and the server returns the generated HTML to the client.

![](/JSP%20Tutorial/images/Client%20Server%20Relationship.png)

**_For making JSP pages, we recommend using Netbeans! Netbeans is an excellent IDE for making JSP pages!_**

## Creating a JSP project in NetBeans
1. Go to File and create a new project, it will prompt you to choose a project select Java Web then web application.

![](/JSP%20Tutorial/images/Step%201.png)

2. Input the project name and location, then proceed.

![](/JSP%20Tutorial/images/Step%202.png)

3. After choosing the name and server settings, you are to choose a server. You may use Glassfish or Tomcat, however it is recommended that we should use Tomcat. Do not edit the Jave EE Version! Then click Finish.

![](/JSP%20Tutorial/images/Step%203.png)

## Installing JDBC
After creating the project, you would see the contents of the new project folder. The Web Pages should contain all the HTML and JSP pages. For the source package, it is recommended to name the package. You can do so by right clicking the `<default package>` and selecting java package. Packages are important in JSP files because you may need to call the objects stored inside the package in order to interact with Java Objects. Now we are going to add the sql connector **(JDBC)**. Through JDBC, we can establish a connection to the database, issue mysql queries such as CRUD (Create, Read, Update, Delete) operations. 

![](/JSP%20Tutorial/images/JDBC%201.png)

To add the sql connector right click on the project name and select properties. Go to the Libraries Category and click add JAR/Folder then select the mysql-connector-java jar. After adding, it should look like this:

![](/JSP%20Tutorial/images/JDBC%202.png)

**_Note: If you do not have the mysql-connector-java-8.0.18 jar, you may download it [here](https://downloads.mysql.com/archives/c-j/) then follow the [download instructions](#MySQL-connector-jar-download-guide)_**

## MySQL connector jar download guide
1. Select the product version and the OS, (for windows, choose platform independent)
2. Choose the zip archive and after downloading extract the zip.

![](/JSP%20Tutorial/images/MySQL%20Connector%201.png)

3. **Only get the JAR FILE.** You do not need the other files. We recommend placing the JAR File under Libraries folder on the project.

![](/JSP%20Tutorial/images/MySQL%20Connector%202.png)

![](/JSP%20Tutorial/images/MySQL%20Connector%203.png)

**_Note: In case you decided to move the JAR file it is recommended to check the location again on the project properties. Sometimes it prompts an error saying the JAR file is not present in the directory._**

## Tomcat error guide
For those who are having an error with their tomcat kindly do the following: 
1. Right click project name and click on **properties** then go to **Run**. Make sure that the Server is **Apache Tomcat 8.0.3.0** based from NetBeans. If it is then make sure to proceed to the next step. If there is no Apache Tomcat then you might have to reinstall NetBeans and add the Tomcat server alongside the Glassfish!
2. Read the error: if it says something about `catalina.bat`, do the following:
   - Go to program files and find the **Apache Software Foundation folder**
   - Select the folder to the corresponding Tomcat server then go to **bin** then right click the catalina having the windows batch file as type and edit with notepad++ *(make sure to launch the notepad++ in administrator mode)*. CTRL+F and search for `:noJuliConfig` and `:noJuliManager`, you might have to remove the quotations from the set **JavaOPTS** file similar below:

![](/JSP%20Tutorial/images/Tomcat%20Error%201.png)

   - Go back to the previous directory and go to the conf folder. You might have to edit the tomcat-users file using notepad++ by editing the commented roles similar to below:

![](/JSP%20Tutorial/images/Tomcat%20Error%202.png)

   - **IF THE PROBLEM STILL PERSISTS**, search the `%appdata%` folder on your search bar and go to Roaming. Once you are in roaming go to Netbeans folder and go to **version 8.0** folder then **apache-tomcat-8.0.3.0_base** folder then the **conf** folder. Edit the **tomcat-users file** with notepad++ similar to what was done above however with additional modifications:

![](/JSP%20Tutorial/images/Tomcat%20Error%203.png)

***NOTE USERNAME AND PASSWORD CAN BE ACQUIRED FROM NETBEANS SERVERS. GO TO TOOLS>SERVERS>APACHE TOMCAT 8.0.3.0 THEN YOU CAN SEE THE USERNAME AND SHOW PASSWORD***

**However if the problem still persists after doing all the steps above, you may search the problem up online.**