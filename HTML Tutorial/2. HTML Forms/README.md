# HTML Forms
## What are forms?
The form tag is used to group certain inputs together to be submitted. This is a way to take input from the user and send it to another file for processing. A sample can be found [here](/HTML%20Tutorial/2.%20HTML%20Forms/1.%20Basic%20HTML%20Forms.html).

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/HTML%20Form.png)

The `<label for="fullname"></label>` creates a text label for a certain input. In this case, the `for="fullname` attribute defines which input the label is bound to (i.e. `<input type="text" id="fullname" name="fullname" required>`). When the user clicks the label, it will automatically highlight the input with an id matching its for attribute.

The `<input type="text" id="fullname" name="fullname" required>` allows the user to input data. The `type="text"` attribute is used to define what type of input is needed from the user (`type=”text”` is used for plain text inputs). The `name="fullname"` attribute defines what the value inside the input will be named as once submitted. The `required` attribute makes it so that the user can’t submit the form while this field is still empty.

The `<input type="submit" value="Submit Form">` is the submit button for the form. The `type="submit"` indicates that this is a submit button. The `value="Submit Form"` defines what will be written on the button.

## Output
![](/HTML%20Tutorial/2.%20HTML%20Forms/images/HTML%20Form%20Output.png)

## More advanced input types
[Check the example here](/HTML%20Tutorial/2.%20HTML%20Forms/images/2.%20More%20Advanced%20Input%20Types.html)

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Password%20HTML.png)

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Password%20Output.png)

Inputs with `type=”password”` hide the string written inside them.

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Number%20HTML.png)

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Number%20Output.png)

Inputs with `type=”number”` only accept numeric inputs.

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Date%20HTML.png)

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Date%20Output.png)

Inputs with `type=”date”` accepts a formatted date and opens up a calendar when clicked.

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Email%20HTML.png)

![](/HTML%20Tutorial/2.%20HTML%20Forms/images/Email%20Output.png)

Inputs with `type=”email”` only accepts properly formatted emails.