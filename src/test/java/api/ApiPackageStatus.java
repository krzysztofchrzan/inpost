package api;

import config.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Assert;


public class ApiPackageStatus {
    private Properties properties = new Properties();
    private String url;
    private Response response;

    @Before(value = "@api")
    public void setupApi() {
        properties = ConfigReader.getConfig();
        url = properties.getProperty("REST_API_URL");
    }


    @When("wyśle zapytanie o status paczki o numerze {string}")
    public void sendRequest(String packageNumber) {
        String simpleDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(Calendar.getInstance().getTime());
        RestAssured restAssured = new RestAssured();
        var finalUrl = String.format("%s/?number=%s", url, packageNumber);
        response = restAssured
            .given()
            .header("Accept-Ranges", "bytes")
            .header("Accept-Language", "en-US")
            .header("User-Agent", "Mozilla/5.0")
            .header("Date", simpleDate)
            .header("Connection", "keep-alive")
            .header("Host", "inpost.pl")
            .header("Content-Type", "application/json")
            .header("X-Requested-With", "XMLHttpRequest")
            .get(finalUrl)
            .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Then("paczka powinna miec status {string}")
    public void assertPackageStatus(String expectedStatus) throws IOException {
        var actualStatus = response.jsonPath().getString("status");
        Assert.assertEquals(actualStatus, expectedStatus);

        saveJson();
    }

    private void saveJson() throws IOException {
        var status = response.jsonPath().getString("status");
        var type = response.jsonPath().getString("type");
        var targetMachineName = response.jsonPath().getString("custom_attributes.target_machine_detail.name");
        var finalMachineName = targetMachineName != null ? targetMachineName : "not_found";

        var line = String.format("%s;%s;%s\n", status, type, finalMachineName);
        FileWriter fileWriter = new FileWriter("./target/reports/packages.csv", true);
        fileWriter.write(line);
        fileWriter.close();
    }
}
