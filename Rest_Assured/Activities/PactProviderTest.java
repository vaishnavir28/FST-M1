package Activities;

import java.net.MalformedURLException;
import java.net.URL;
​
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
​
import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
​
@Provider("MY_PROVIDER")
@Consumer("MY_CONSUMER")
@PactFolder("target/pacts")
public class PactProviderTest {
	@BeforeEach
	void before(PactVerificationContext context) throws MalformedURLException {
		// Set target for provider to send request to
		context.setTarget(HttpTestTarget.fromUrl(new URL("https://localhost:8080")));
	}
​
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactTestTemplate(PactVerificationContext context) {
		// Verify the interaction between Consumer and Provider
		// using the contract generated in target/pacts
		context.verifyInteraction();
	}
​
	// State to send the call to consumer
	@State("A request to create a meeting for my provider")
	public void sampleState() {}
}