import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Map<String, Object> model = new HashMap<>();
        get("/", (request, response) -> {
            model.put("squads", Squad.getSquadInstance());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squadform", (request, response) -> {
            return new ModelAndView(model, "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squadform", (request, response) -> {
            String squadName = request.queryParams("squad_name");
            String squadCause = request.queryParams("squad_cause");
            int maxSize = Integer.parseInt(request.queryParams("max_size"));
            Squad newSquad = new Squad(squadName, squadCause, maxSize);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }
}
