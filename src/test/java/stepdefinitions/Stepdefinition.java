package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class Stepdefinition{

    Response response;
    RequestSpecification spec;

    Random rnd = new Random();
    int id = rnd.nextInt(731);;

    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
    }


    @Given("set a random id path parameter")
    public void setARandomIdPathParameter() {

        spec.pathParam("pp1",id);
        response = given().contentType(ContentType.JSON).spec(spec).when().get("/{pp1}");

    }

    @Then("get the superhero with given id")
    public void getTheSuperheroWithGivenId() {

        //response.prettyPrint();
        JsonPath resPath = response.jsonPath();

        System.out.printf("SuperHero with the id " + id +" has the name " + resPath.get("name").toString());
        System.out.println("");
        String url = resPath.get("image").toString();
        System.out.println("Click on the link to see image of the Superhero");
        System.out.printf(url);

    }



    @Given("set a random id with {string} path parameter")
    public void setARandomIdWithPathParameter(String biography) {

        spec.pathParams("pp1",id,"pp2",biography);
        response = given().contentType(ContentType.JSON).spec(spec).get("/{pp1}/{pp2}");

    }

    @Then("get the biography of the SuperHero")
    public void getTheBiographyOfTheSuperHero() {

        response.prettyPrint();
    }

    @Given("set a random id with {string} path param")
    public void setARandomIdWithPathParam(String appearance) {

        spec.pathParams("pp1",id,"pp2",appearance);
        response = given().contentType(ContentType.JSON).spec(spec).get("/{pp1}/{pp2}");

    }

    @Then("get the appearance of the SuperHero")
    public void getTheAppearanceOfTheSuperHero() {
        response.prettyPrint();
    }

    @Given("set a random id with {string} parameter")
    public void setARandomIdWithParameter(String arg0) {

        spec.pathParams("pp1",id,"pp2","work");
        response = given().contentType(ContentType.JSON).spec(spec).get("/{pp1}/{pp2}");
    }

    @Then("get the work of the SuperHero")
    public void getTheWorkOfTheSuperHero() {

        response.prettyPrint();
    }
}
