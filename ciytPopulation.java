//package com.api.test.Apitesting;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
class cityPopulation {
    @Test
    void fetchCityPopulation() {
        String apiUrl = "https://countriesnow.space/api/v0.1/countries/population/cities/q";
        Response response = given()

                .contentType(ContentType.JSON)
                .queryParam("city", "Lagos")
                .queryParam("country", "Nigeria")
                .when()
                .get(apiUrl);
        response.prettyPrint();
        int population = response.jsonPath().getInt("data.populationCounts[0].value");
        System.out.println("Population of Lagos: " + population);
    }
}