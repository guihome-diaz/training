package eu.daxiongmao.springtraining.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to manage the homepaage (index).<br>
 * This is based on the spring 5 training "beginner to Guru" from John Tompson (see
 * <a href="https://www.udemy.com/spring-framework-5-beginner-to-guru/>UDEMY</a>).
 * @version 1.0
 * @author guillaume Diaz
 */
@Controller
public class HomepageController {

    /**
     * To get the default landing page (homepage).<br>
     *     <br>
     *         You can access that page in 3 different ways:
     *         <ul>
     *             <li>without anything (""): application root URL (ex: http://localhost:8080)</li>
     *             <li>With the slash ("/"): application URL that ends with a slash (ex: http://localhost:8080/)</li>
     *             <li>With the index suffix: application URL + /index (ex: http://localhost:8080/index)</li>
     *         </ul>
     * @return name of the home page to display (index)
     */
    // example of multi-path mapping
    @RequestMapping({"", "/", "/index"})
    public String getHomePage() {
        return "index";
    }
}
