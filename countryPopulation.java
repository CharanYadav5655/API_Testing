import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
class CountryPopulation {
    @Test
    void fetchCountryPopulation() {
        RestAssured.baseURI = "https://countriesnow.space/api/v0.1";
        String requestBody = "{ \"country\": \"Zimbabwe\" }";
        Response postResponse = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/countries/population");
        int statusCode = postResponse.statusCode();
        String redirectedUrl = postResponse.getHeader("https://countriesnow.space/api/v0.1/countries/population/q? country=Zimbabwe");
                Response finalResponse;
        if (statusCode == 301 || statusCode == 302) {
            finalResponse = given().get("https://countriesnow.space/api/v0.1/countries/population/q?country=Zimbabwe");
        } else {
            finalResponse = postResponse;
        }
        System.out.println("Final Response Status: " + finalResponse.statusCode());
        System.out.println("Final Response:");
        finalResponse.prettyPrint();
    }
}