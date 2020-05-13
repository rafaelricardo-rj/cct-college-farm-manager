/** Class with method that return some application's data
 * @since   2020-05-12*/
package ie.cct.ca2019206.scaffold;

import java.util.HashMap;

public class ProjectDetails {
    /**
     * This method return basic data from the app
     * @return HashMap */
    public static HashMap<String, String> load(){
        HashMap<String, String> apiRoot = new HashMap<>();
        apiRoot.put("path","API Root (/)");
        apiRoot.put("apiVersion","1.0");
        apiRoot.put("studentName","Rafael Ricardo");
        apiRoot.put("studentId","2019206");
        apiRoot.put("moduleTitle","Cloud Based Web Applications");
        apiRoot.put("projectTitle","Farm Manager");
        apiRoot.put("projectDate","March 2020");
        apiRoot.put("assignmentCompiler","David Gonzalez");
        apiRoot.put("dueDate","Sunday, 17th May 2020 @ 23:59");
        apiRoot.put("course","Higher Diploma in Science of Computing");
        apiRoot.put("college","CCT College Dublin");
        return apiRoot;
    }

    public static String homePage(){
        return "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Farm Manager - V.1.0</title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='background-color: lightblue;'>\n" +
                "    <div style='max-width: 1000px; margin-left: auto; margin-right: auto;'>\n" +
                "        <p><b>Module Title:</b> Cloud Based Web Applications</p>\n" +
                "        <p><b>Assignment Type:</b> Integrated Individual Practical Assignment</p>\n" +
                "        <p><b>Project Title:</b> Farm Manager</p>\n" +
                "        <p><b>Project Date:</b> March 2020</p>\n" +
                "        <p><b>Assignment Compiler:</b> David Gonzalez</p>\n" +
                "        <p><b>Student:</b> Rafael Ricardo (rafael_rikardo@yahoo.com.br)</p>\n" +
                "        <p><b>GitHub:</b> <a href=\"https://github.com/rafaelricardo-rj/cct-college-farm-manager\">https://github.com/rafaelricardo-rj/cct-college-farm-manager</a></p>\n"+
                "\n" +
                "        <h3>Farm Manager is an application that aims to manage the sale of animals on a farm.</h3>\n" +
                "\n" +
                "        <b>Note</b>\n" +
                "        <p>\n" +
                "            The application is an API developed in Java language and uses the Spring framework (Spring boot Version\n" +
                "            2.2.7),\n" +
                "            Java 8, packing JAR and Graddle compiler. This is not an application for commercial use as it is an\n" +
                "            Assignment\n" +
                "            of\n" +
                "            semester completion of the Higher Diploma in Science in Computing course at CCT College in order to show\n" +
                "            basic\n" +
                "            knowledge of Spring resources as a framework for API development.\n" +
                "        </p>\n" +
                "\n" +
                "        <b>The features offered by this tool are:</b>\n" +
                "        <ol>\n" +
                "            <li>List all the animals.</li>\n" +
                "            <li>Add a new animal</li>\n" +
                "            <li>Calculate the average weight of each type of animal</li>\n" +
                "            <li>How many animals of each type can be sold right now.</li>\n" +
                "            <li>What is the current value of the full farm stock (the price of all animals that can be sold right now)\n" +
                "            </li>\n" +
                "            <li>What is the current value of the farm assuming the price of each animal is set by a parameter in the\n" +
                "                HTTP request</li>\n" +
                "        </ol>\n" +
                "        <p><b>Base URL:</b> localhost:8080<br>Display this information.</p>\n" +
                "        <p><b>Base API URL:</b> localhost:8080/api<br>Displays basic API data such as version, author and resources.</p>\n" +
                "        <b>Available API end-points:</b>\n" +
                "        <p><b>GET /animals</b>\n" +
                "            <br>\n" +
                "            Responsible for listing all the animals currently on the farm.\n" +
                "            Each animal is displayed showing its id, type, weight and value.\n" +
                "        </p>\n" +
                "        <p><b>POST /animals</b>\n" +
                "            <br>\n" +
                "            Adds a new animal to the farm.\n" +
                "        </p>\n" +
                "        <p><b>GET /animals/average-weight</b>\n" +
                "            <br>\n" +
                "            Returns the average weight of each animal on the farm.\n" +
                "        </p>\n" +
                "        <p><b>GET /animals/for-sale</b>\n" +
                "            <br>\n" +
                "            Returns the quantity of animals available for sale. Omitting the 'type' parameter, all the types of animals\n" +
                "            are\n" +
                "            returned. To return only one type of animal, the following parameter must be added at the end of the\n" +
                "            end-point: '?type=cow' or '?type=pig' or '?type=chicken'.\n" +
                "        </p>\n" +
                "        <p><b>GET /animals/total-stock</b>\n" +
                "            <br>\n" +
                "            This end-point returns two values, 'totalValue' and 'totalValueToSell'. The first reports the total value of\n" +
                "            animals\n" +
                "            on the farm, the second shows the stock value considering only the animals that have already reached the\n" +
                "            minimum\n" +
                "            weight for sale.\n" +
                "        </p>\n" +
                "        <p><b>GET /animals/total-stock-simulation</b>\n" +
                "            <br>\n" +
                "            Similar to the previous end-point, this feature accepts HTTP parameters request by changing the values \u200B\u200Bof\n" +
                "            each\n" +
                "            animal to reflect a new stock value based on these parameters.<br>\n" +
                "            For example: '/animals/total-stock-simulation?cow=520' will return the stock value considering that cow has\n" +
                "            a value of 520.<br>\n" +
                "            It is possible to use up to 3 parameters.<br>\n" +
                "            Example: '/animals/total-stock-simulation?cow=520&pig=200&chicken=4'. In this example the return will be the\n" +
                "            total\n" +
                "            value of the stock considering the values \u200B\u200Bof each animal passed by the parameters 'cow', 'pig' and\n" +
                "            'chicken'.\n" +
                "            If one of the parameters is omitted or if no parameters are passed, the calculation will be based on the\n" +
                "            standard\n" +
                "            market values \u200B\u200Bof each animal declared in the Enum class within the system. If a parameter is used\n" +
                "            correctly but\n" +
                "            the value is not a valid double, a Bad Request code 400 error message will be returned from the API.<br>\n" +
                "            Parameters with wrong name are ignored, then the default market value is taken.\n" +
                "        </p>\n" +
                "        <b>Types of animals on the farm:</b>\n" +
                "        <ul>\n" +
                "            <li>Cow</li>\n" +
                "            <li>Pig</li>\n" +
                "            <li>Chicken</li>\n" +
                "        </ul>\n" +
                "        <b>Market value of each animal(£):</b>\n" +
                "        <ul>\n" +
                "            <li>Cow - 500.0</li>\n" +
                "            <li>Pig - 100.0</li>\n" +
                "            <li>Chicken - 5.0</li>\n" +
                "        </ul>\n" +
                "        <b>Minimum weight for sale of each animal (Kg):</b>\n" +
                "        <ul>\n" +
                "            <li>Cow - 300.0</li>\n" +
                "            <li>Pig - 100.0</li>\n" +
                "            <li>Chicken - 5.0</li>\n" +
                "        </ul>\n" +
                "        <b>Application structure and packages:</b>\n" +
                "        <p><b>/</b><br>Root of the project folder. It has only the main class of the application with the main ()\n" +
                "            method.</p>\n" +
                "        <p><b>/controllers</b><br>It has all classes responsible for handle requests from the client and has the\n" +
                "            necessary logic to return the requested data.</p>\n" +
                "        <p><b>/enum</b><br>Classes with constants that can be used in different parts of the application. This is useful\n" +
                "            for better maintenance as it concentrates the constants in a single point.</p>\n" +
                "        <p><b>/helpers</b><br>It has classes that help some tasks.</p>\n" +
                "        <p><b>/model</b><br>Responsible to host classes that represent entities that will be persisted or not. In this\n" +
                "            application only one class is used and there is no persistence.</p>\n" +
                "        <p><b>/scaffold</b><br>It has classes that are used in the loading of the system to generate some values in\n" +
                "            memory for use. For example: Animals are created automatically when the system starts using the LoadAnimals\n" +
                "            class present in this package.</p>\n" +
                "        <p><b>/utils</b><br>There are some classes with static methods that assist in small tasks performed in\n" +
                "            controller classes</p>\n" +
                "        <b>For more details on each class and method, access the class to read their comments.</b>\n" +
                "        <p>\n" +
                "            <b>P.s</b>\n" +
                "            <br>\n" +
                "            This application could be much simpler but I decided to explore some things I have learnt in the semester\n" +
                "            like the use of Singleton and Enum for example.<br>\n" +
                "            Also just for testing I created an additional controller to reply requests done to the base URL of the API.\n" +
                "            This was also not required in the documentation\n" +
                "            but I did it to test the creation of a new route using a new controller.<br>\n" +
                "            The utils folder with some classes was created in order to reduce the amount of code in the methods of the\n" +
                "            controller classes, helping to perform some\n" +
                "            operations and keeping these methods more organized and readable.<br>\n" +
                "            A second reason for all these additions to the project was to try to follow a development practice that I\n" +
                "            use in another language and try to reproduce\n" +
                "            the same thing with Java, although I believe that Java should have its recommended development standards\n" +
                "            that may differ from that adopted in other languages.\n" +
                "        </p>\n" +
                "        <p><b>@author</b> Rafael Ricardo - Student number: 2019206</p>\n" +
                "        <p><b>@version</b> 1.0</p>\n" +
                "        <p><b>@since</b> 2020-05-12</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
