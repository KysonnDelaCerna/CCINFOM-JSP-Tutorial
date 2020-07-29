# Making a JSP Web Page

## Table of contents
1. [Creating the HTML page](#Creating-the-HTML-page)
2. [Creating the JSP page](#Creating-the-JSP-page)
3. [Testing the JSP page](#Testing-the-JSP-page)
   - [Create product](#Create-product)
   - [Update product](#Update-product)
   - [Delete product](#Delete-product)
4. [Merging HTML and JSP](#Merging-HTML-and-JSP)

## Creating the HTML page
Now that we set up our models, it’s time to create a web page that will allow us to create a jsp or html page! Note that jsp files have .jsp as their extension and normal HTML files have .html! As we said earlier, jsp cannot be viewed automatically without a server, but the perks of jsp is that you can render dynamic data and inject java codes into HTML.

Let’s create a basic HTML page that will create a product:

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Create%20HTML%201.png)

The picture above is the html code and the picture below is the equivalent view of the html code the client sees. We saved it as productCreate.html, you can use any name you want. You can see the html equivalent by right clicking on the code editor and selecting run file!

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Create%20HTML%202.png)

***Naming is important because you would want to retrieve the data from the client later on in JSP***

If you are using Tomcat and are experiencing errors, you can check the guide [here](/JSP%20Tutorial#Tomcat-error-guide)

## Creating the JSP page
Now we are going to create the jsp page. Go to **Web pages>New>JSP** then input your desired name, we used prodCreate.jsp because that is where we will be redirected based on the action attribute of the form element.

To inject java codes, you will have to insert an opening and a closing via: `<% %>`. Anything included inside the `<% %>` are pure java codes only! You cannot inject html codes inside `<% %>`.

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Create%20JSP%201.png)

Let’s break down the code one by one. First is importing, we need to import the necessary packages in java or the code will not work the syntax is: `<%@page import=””%>`, inside the import are the packages such as `java.sql.Date`, and the package name of your java file.

Now for the date, the example will be using `Calendar` while others can use other methods such as `SimpleDateFormat` etc.

Now based on the client-server model earlier, all of the inputs of the user in the text box are considered as **REQUESTS**. That is why in the jsp file, in order to get the value inputted by the user, we will call `request.getParameter()` and inside the `getParameter()` method is the name of the element inside the HTML document. So for `product.productID`, it will be value accessing the `productID` of the HTML text box. 

For the calendar, we created an instance of the current date the server is on, then we assigned the date. That is why there is no date textbox on the html page!

**Note: All values of the text box are automatically written in String, that is why we had to parse the value to Integer.**

All we have to do is call the `createProduct()` and a product is created! 

Now that we have created the product, we wouldn’t want to remain in just the JSP page further, that is why we have to redirect the page, this can be done by `response.sendRedirect()`, it redirect the page to the name of the html or jsp file!

## Testing the JSP page
### Create product
![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Create%201.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Create%202.png)

As you can see above, the DragonFruit has been added to the table!

*Note: The methods are similar as well to the other operations like Update and Delete, however Select is different slightly but not too much.*

### Update product
![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Update%201.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Update%202.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Update%203.png)

### Delete product
![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Delete%201.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Delete%202.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Test%20Delete%203.png)

## Merging HTML and JSP
Let’s try creating a query page where it shows the list of products in the database.

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Merged%201.png)

Compared to the other operations, select is slightly different. This is because we want to retrieve and display operations unlike the insert, update and delete, we would only want to update the records and we do not desire like a query of updated records immediately. In the select operation you may notice that there are interchangeable `<% %>`, that is because as we said earlier, you cannot insert HTML tags inside the `<% %>` however you can inject java in HTML! In this example, we fill up every row of the table based on the list of products queried. 

Also you might notice `<%= %>` this one, when you are injecting data, it is important to specify the `=`, however if you’re adding codes, it is best not to include the `=` symbol.

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Merged%202.png)

![](/JSP%20Tutorial/2.%20Making%20a%20JSP%20Web%20Page/images/Merged%203.png)

At the output above, the records (rows) in our database matches the one in the mysql. 