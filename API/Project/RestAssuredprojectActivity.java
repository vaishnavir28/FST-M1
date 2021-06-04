import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredprojectActivity {
	RequestSpecification requestSpec;

	int id;
	String ssh="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC6vPQ1crgpwvIjxfIljSRHgmjXZkAMtWSDuYRltZqzbiDpmqLbyNFtR8GYeIlh/rc7tgCefl4qW6qn+E3GvynWkSDLYYaOAt3704Oju+wmWpohAR++Ufww6FtbuvQLG+PdVswrUAPA0+pjguatM8m/47PsQORsCdeabhQaKIzkDSy3K4hnyQvJyQj+acYAP9RKQjdqzPT59Do1eat1rtySdNV8sPg6THcKd0dzsm0ww9XvlJ+eWZyLWknWL6EduPiaJi8DZufAbCsj8prbwTzpPSx3YQtOTLcSmTIzf3PUl4evJhCMHtxZnFIEzK46x5MyRC/9yJ2GioS1RAb7f3f5 gmx";

	@BeforeClass
	public void setUp() {
		String token ="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";
		// Create request specification
		requestSpec = new RequestSpecBuilder()
				// Set content type
				.setContentType(ContentType.JSON)
				//set Token
				.addHeader("Authorization", "Bearer "+token)
				// Set base URL
				.setBaseUri("https://api.github.com")
				// Build request specification
				.build();
	}
	@Test(priority=1)

	public void addKeys() {
		String reqBody = "{"
				+ "\"title\": \"TestAPIKey\","
				+ "\"key\":\""+ssh+"\""
				+ "}";
		Response response = given().spec(requestSpec) // Use requestSpec
				.body(reqBody) // Send request body
				.when().post("/user/keys"); // Send POST request

		id = response.then().extract().path("id");
		System.out.println(id);
		response.then()
		.statusCode(201);
	}
	@Test(priority=2)
	public void getkeys() {
		Response response = given().spec(requestSpec) // Use requestSpec
				.when().get("/user/keys"); // Send GET request

		// Print response
		System.out.println( response.then().log().all());
		// Assertions
		response.then()
		.statusCode(200);
	}



	@Test(priority=3)
	public void deletekeys(int id) { 
		Response response =
				given().spec(requestSpec) 
				 .pathParam("keyId", id)
				.when().delete("/user/keys/{keyId}"); 
		System.out.println( response.then().log().all()); 
		response.then()
		.statusCode(204);
		}

}