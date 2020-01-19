import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder ();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default localhost port if heroku-port isn't set.
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Map<String, Object> model = new HashMap<>();
        get("/", (request, response) -> {
            model.put("squads", Squad.getSquadInstance());
            model.put("heroes", Hero.getHeroInstance());
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

        get("/heroform", (request, response) -> {
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroform", (request, response) -> {
            String heroName = request.queryParams("hero_name");
            String heroAge = request.queryParams("hero_age");
            String specialPower = request.queryParams("special_Power");
            String heroWeakness = request.queryParams("hero_weakness");
            Hero newHero = new Hero(heroName, heroAge, specialPower, heroWeakness );
            response.redirect("/");
            return null;
        });

    }
}
