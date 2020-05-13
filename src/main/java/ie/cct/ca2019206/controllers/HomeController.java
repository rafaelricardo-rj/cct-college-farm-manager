/**
 * Contoller responsible for the root of the API /
 * Available resources:
 * 1 Show information about the application.
 *
 * @author  Rafael Ricardo - Student number: 2019206
 * @since   2020-05-12
 * */

package ie.cct.ca2019206.controllers;

import ie.cct.ca2019206.scaffold.ProjectDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Constructor of the class call the load data from the application.
 * @see ie.cct.ca2019206.scaffold.ProjectDetails ProjectDetails */
@RestController
public class HomeController {
    @GetMapping("/api")
    public HashMap<String, String> indexApi() {
        return ProjectDetails.load();
    }

    @GetMapping("/")
    public String index(){
        return ProjectDetails.homePage();
    }
}
