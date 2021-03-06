import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("public");

        get("/", (request, response) -> { // Request for route happens at this location
            Map<String, Object> model = new HashMap<String,Object>(); // new model is made to store information
            return new ModelAndView(model, "hello.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            return new ModelAndView(new HashMap(), "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
