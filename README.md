# Practice_Project_Plant
Small practice project
Done in 4.5 h

## Tasks
A) create a custom Plant class in the model package that describes the design of the plant, 
define default constructors for it, also constructors with parameters to initialize any two fields and to initialize all fields (3 constructors in total). 
The Plant class has fields: name, color, number of stems, lifetime, market price.

Create methods in the Plant class
1. Method for increasing the field of (any) plants by a given value in the arguments
2. A method that returns the value of the field of (any) plant.

B) Create the configuration class Size, which describes the size of plants. 
Set an object of class Size as the Plants' field.
Class fields Size: length, height, perimeter of the plant. 
Create Default constructors and with arguments (length and height), 
make the perimeter an automatically calculated field, specify a separate setPerimetr method.

C) Create a Garden class layout that has an array of plants as a field. 
A constructor with only an array parameter that initializes the argument argument n.

D) Implement Clonable to all classes
E) Add copy constructors for all calsses

### Tasks for Garden class methods implementation
1. add - an object of the Plant type that adds Plamnt to the array of plants, returns true or false - whether the Plant was added to the array or not.
2. get - taking the index of the plant, return the plant from the array of plants to its input index or null if index is incorrect.
3. count - returns the actual number of plants in the garden
4. search - input the name of the plant and return the found object or null if such an object was not found
5. search - input for a plant object and returns its index in the list of all plants in the garden, or -1 if no such object is found
6. delete - input name of the plant remove found the plant from the garden, transfer all plants after the deleted one to the left, return the deleted plant object
7. delete- input the plant object and emove found the plant from the garden, moving all plants after the removed one to the left, returns a boolean value, whether the plant was removed or not.
8. insert -input the index and the object Plant, method adds this Plant  at the given index, a boolean value is returned, whether or not the plant was inserted successfully
