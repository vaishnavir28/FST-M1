package Activities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
​
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
​
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
​
@ExtendWith(PactConsumerTestExt.class)
public class PactConsumerTest {
	// Create Map for the headers
	Map<String, String> headers = new HashMap<String, String>();
​
	// Set resource URI
	String createMeeting = "/manage/create-meeting";
​
	// Set date format
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	String nowAsISO = df.format(new Date());
​
	// Create Pact contract
	@Pact(provider = "MY_PROVIDER", consumer = "MY_CONSUMER")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {
		// Add headers
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Authorization", "Bearer 1EYvqTahHaExNcDHjDaNkQ");
​
		// Create request JSON
		DslPart bodySentCreateMeeting = new PactDslJsonBody()
			.stringType("title", "My title")
			.date("start_time", "yyyy-MM-dd'T'HH:mm:ss'Z'")
			.stringType("provider", "MY_PROVIDER")
			.numberType("duration", 30);
​
		// Create response JSON
		DslPart bodyReceivedCreateMeeting = new PactDslJsonBody()
			.stringType("topic", "My title")
			.stringType("id", "94735196626")
			.stringType("start_url", "https://my_url.com")
			.date("start_time", "yyyy-MM-dd'T'HH:mm:ss'Z'", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(nowAsISO))
			.numberType("duration", 30);
​
		// Create rules for request and response
		return builder.given("A request to create a meeting for my provider")
			.uponReceiving("A request to create a meeting for my provider")
				.path(createMeeting)
				.method("POST")
				.headers(headers)
				.body(bodySentCreateMeeting)
			.willRespondWith()
				.body(bodyReceivedCreateMeeting)
			.toPact();
	}
​
	@Test
	@PactTestFor(providerName = "MY_PROVIDER", port = "8080")
	public void runTest() {
		// Mock url
		RestAssured.baseURI = "http://localhost:8080";
		// Create request specification
		RequestSpecification rq = RestAssured.given().headers(headers).when();
​
		// Create request body
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "MyTitle");
		map.put("start_time", nowAsISO);
		map.put("provider", "MY_PROVIDER");
		map.put("duration", 30);
​
		// Send POST request
		Response response = rq.body(map).post(createMeeting);
​
		// Assertion
		assert(response.getStatusCode() == 200);
​
	}
​
}