
For this assignment we wanted to try out splitting up the work much more and only having 
responsibility for our designated tasks. We did however do a lot of debugging together and we 
did help each other when necessary.

Love
- 1.2 The Company 
- 1.4 Remove stored employees 
- 1.7 Retrieve expenses with total salary 
- 1.10 Show the number of employees per degree 
- 2.1 No employee found. 
- 2.4 Presenting the creation or assignment with invalid Manager data. 

Emma
- 1.3 Create different types of employees 
- 1.5 Retrieve string from an employee 
- 1.8 Retrieve employees sorted by gross salary. 
- 2.2 Specific employee not found or not registered yet.
- 2.5 Presenting the creation or assignment with invalid Directors data.

Martin
- 1.1 Create and store regular employees 
- 1.6 Retrieve a string including all employees 
- 1.9 Update Employee’s Information 
- 2.3 Preventing the creation or assignment with invalid Employee data. 
- 2.6 Preventing the creation or assignment with invalid Interns data. 

Together:
- Design Task (Factory Pattern)
- 1.11 Promotion of employees

Overall thoughts:
We we're a bit confused about this task, since it said that we were supposed to have four methods
for the four possible positions, but also that there is no promotion to regular employee. We 
still ended up with four methods since we overloaded promoteToDirector() but we are unsure if that
is what the assignment meant by saying four methods. We also deviated a little bit from 
the summary of the task by firstly retrieving and removing the employee simultaneously and also by
not saving the information in variables, since we use use the getters at creation instead. We do not
however believe this negatively affects the functionality and readability of the method.

Comment from Martin:
I believe that the main limitation of inheritance in regards to these promotion methods is the fact
that you cannot use the same promotion method for all types of employees. The reason for this is that
some employees have attributes in common with the type they are being promoted to, in which case you
can just use a getter to receive those, but others employess do not and need them as arguments. 
In our case we used overloading to solve this issue, which works fine, but significanly worsens the 
extendability of the code. For every employee we add we might have to write several overloaded methods,
based on if they share some attributes with one type of employee and some attribute with another.
In summary, I believe we did solve the problem well in this case, but the trade-off lies in making the
code harder to extend and maintain.


Comment from Love:
For task 1.11, handling the promotion of employees, we didn't follow exactly what the assignment told us to do.
Instead, we save the object at the same time that we remove it from the HashMap. This is because the hashmap remove
method partly removes the object from the hashmap, but also stores the value that we remove. Therefore, basically,
we retrieve, save, and remove all at the same time. Thus, when we later create the "new" employee with the corresponding
type, we already have the information needed to create it stored in the object, so what we can do is that we use the
getter methods to get the attributes saved inside the object. (An example of this is employee.getName). Depending
on what type of employee we are promoting to, we then add the attributes required to create a valid employee of said type.

Overall, I'd say that the main limitation when it comes to inheritance is the fact that we need the step to -remove- the "old"
employee. Instead of just getting an employee and updating the value of the object in the hashmap, we actually have to remove
it, create a new with the same attributes (plus or minus the attributes required for said promotion). Another trade off is 
that we have to have four different methods, aka, we can't have one method that promotes based on the parameters passed. 
This is especially noticeable when looking at our two promoteToDirector methods. In one of the methods, we have two arguments
passed; String employeeID and String department. In the other, in the case that the employee getting a promotion didn't 
already have a degree, we need an entire other method for that, when it is in fact just doing the same thing, just taking
different arguments. 

Preferrably, we would've wanted as few promote methods as possible, since we know by the signature of a
method what type of employee we want to promote to. Therefore, it could've been good to be able to have one method that can take
different parameters, but instead, we have to have four different methods. Another limitation is also the fact that the grossSalary
attribute is a calculation based on the type of employee. Therefore, we needed to implement a form of baseSalary, that is the one
we do our calculations to calculate the actual grossSalary with. 

Comment from Emma:
(Unfortunately could not make a comment because of personal matters)

