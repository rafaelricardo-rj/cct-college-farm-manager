
 
  ### Module Title: Cloud Based Web Applications
  ### Assignment Type: Integrated Individual Practical Assignment
  ### Project Title: Farm Manager
  ### Project Date: March 2020
  ### Assignment Compiler: David Gonzalez
  ### Student: Rafael Ricardo (rafael_rikardo@yahoo.com.br)
  ### Documentation: https://rafaelricardo-rj.github.io/cct-college-farm-manager-doc
 
  ## Farm Manager is an application that aims to manage the sale of animals on a farm.
 
  ### Note
  The application is an API developed in Java language and uses the Spring framework (Spring boot Version 2.2.7),
  Java 8, packing JAR and Graddle compiler. This is not an application for commercial use as it is an Assignment of
  semester completion of the Higher Diploma in Science in Computing course at CCT College in order to show basic
  knowledge of Spring resources as a framework for API development.
 
  ### The features offered by this tool are:
  *1 List all the animals.
  *2 Add a new animal
  *3 Calculate the average weight of each type of animal
  *4 How many animals of each type can be sold right now.
  *5 What is the current value of the full farm stock (the price of all animals that can be sold right now)
  *6 What is the current value of the farm assuming the price of each animal is set by a parameter in the HTTP request
 
  ### Base URL: localhost:8080
  Display this information.
 
  ### Base API URL: localhost:8080/api
  Displays basic API data such as version, author and resources.
  
  ### Application demo (Docker): http://rafaelricardo.online:8080
  Display this information in production
  
  ### Application demo Base API URL: http://rafaelricardo.online:8080/api
  Displays basic API data such as version, author and resources.
 
  ### Available API end-points:
 
  ### GET /animals
  Responsible for listing all the animals currently on the farm.
  Each animal is displayed showing its id, type, weight and value.
 
  ### POST /animals
  Adds a new animal to the farm.
 
  ### GET /animals/average-weight
  Returns the average weight of each animal on the farm.
 
  ### GET /animals/for-sale
  Returns the quantity of animals available for sale. Omitting the "type" parameter, all the types of animals are
  returned. To return only one type of animal, the following parameter must be added at the end of the
  end-point: "?type=cow" or "?type=pig" or "?type=chicken".
 
  ### GET /animals/total-stock
  This end-point returns two values, "totalValue" and "totalValueToSell". The first reports the total value of animals
  on the farm, the second shows the stock value considering only the animals that have already reached the minimum
  weight for sale.
 
  ### GET /animals/total-stock-simulation
  Similar to the previous end-point, this feature accepts HTTP parameters request by changing the values ​​of each
  animal to reflect a new stock value based on these parameters.
  For example: "/animals/total-stock-simulation?cow=520" will return the stock value considering that cow has a value of 520.
  It is possible to use up to 3 parameters.
  Example: "/animals/total-stock-simulation?cow=520&pig=200&chicken=4". In this example the return will be the total
  value of the stock considering the values ​​of each animal passed by the parameters "cow", "pig" and "chicken".
  If one of the parameters is omitted or if no parameters are passed, the calculation will be based on the standard
  market values ​​of each animal declared in the Enum class within the system. If a parameter is used correctly but
  the value is not a valid double, a Bad Request code 400 error message will be returned from the API.
  Parameters with wrong name are ignored, then the default market value is taken.
 
  ### Types of animals on the farm:
  * Cow,
  * Pig,
  * Chicken
 
  ### Market value of each animal:
  * Cow - 500.0
  * Pig - 250.0
  * Chicken - 5.0
 
  ### Minimum weight for sale of each animal (Kg):
  * Cow - 300.0
  * Pig - 100.0
  * Chicken - 0.5
 
  ### Application structure and packages:
 
  ### /
  Root of the project folder. It has only the main class of the application with the main () method.
 
  ### /controllers
  It has all classes responsible for handle requests from the client and has the necessary logic to return the requested data.
 
  ### /enum
  Classes with constants that can be used in different parts of the application. This is useful for better maintenance as it concentrates the constants in a single point.
 
  ### /helpers
  It has classes that help some tasks.
 
  ### /model
  Responsible to host classes that represent entities that will be persisted or not. In this application only one class is used and there is no persistence.
 
  ### /scaffold
  It has classes that are used in the loading of the system to generate some values in memory for use. For example: Animals are created automatically when the system starts using the LoadAnimals class present in this package.
 
  ### /utils
  There are some classes with static methods that assist in small tasks performed in controller classes
 
  For more details on each class and method, access the class to read their comments.
 
 
  ### P.s
 
  This application could be much simpler but I decided to explore some things I have learnt in the semester like the
  use of Singleton and Enum for example. Also just for testing I created an additional controller to reply requests
  made in the base URL of the API. This was also not required in the documentation but I did it to test the creation of
  a new route using a new controller.
  The utils folder with some classes was created in order to reduce the amount of code in the methods of the controller classes, helping to perform some operations and keeping these methods more organized and readable.
  A second reason for all these additions to the project was to try to follow a development practice that I use in another language and try to reproduce the same thing with Java, although I believe that Java should have its recommended development standards that may differ from that adopted in other languages.
 
  ### @author  Rafael Ricardo - Student number: 2019206
  ### @version 1.0
  ### @since   2020-05-12