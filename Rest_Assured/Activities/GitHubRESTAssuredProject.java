package Activity_GitHub_RestAssured_Project;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GitHubRESTAssuredProject {
	
	String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDaHc5/jnX/x8TA9Vf8fUaXqgo16AMRhmQFgxPQOL4bVtzNi36RQlguyOZYWU+QDAjjlMNGw6KiAtm9dTsbcmpTz7zSgJozUZjmC8KWcuXSFkufK1GMaO3/l0AXds/QYD82IQBTfrXNb54Zfx3FpNdMUvkkNw/18dSBblyfNQ8swm11kFGH7zhAjbkN27H3sX02GMVdz2Mdgd7mX0jyxGM4f2xDo2Ey6WZfSpUD0LPozykgBp6EhmXQuO0h0EkYBu1SVluSrCFn8zV3rZpSFM4KL/09xter+7yjsAYO9r4+DfYRJBmha38hZXgJy+e9uF5pjs8Ton0snWU1KiOxUm9+zqX9XXnQllLr3CaoOJ0AQq532nbTgGdrws0G93wq3coJCDv6CP0VxTB6UFiTjlspUBtUjuzrDpQH2IEMaLz1pqpMXDFif7jjG7FXhEkx+05psVsMTletRUBh6st/SFX9ny0JkCYImQeBbcAcJC4Zfy5l6FjenVQLxRqRLkUdxnc=";
	int id;
	
	
	// Declare request & Response specification
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {

		// Create request specification
		requestSpec = new RequestSpecBuilder()
				.addHeader("Authorization", "token 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")
				.setContentType(ContentType.JSON).setBaseUri("https://api.github.com").build();
		responseSpec = new ResponseSpecBuilder()

				// Check response content type
				.expectContentType("application/json")
				// Build response specification
				.build();

	}

	@Test

	public void PostRequest() {

		String reqBody = "{ \"title\": \"TestAPIKey\",  \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDaHc5/jnX/x8TA9Vf8fUaXqgo16AMRhmQFgxPQOL4bVtzNi36RQlguyOZYWU+QDAjjlMNGw6KiAtm9dTsbcmpTz7zSgJozUZjmC8KWcuXSFkufK1GMaO3/l0AXds/QYD82IQBTfrXNb54Zfx3FpNdMUvkkNw/18dSBblyfNQ8swm11kFGH7zhAjbkN27H3sX02GMVdz2Mdgd7mX0jyxGM4f2xDo2Ey6WZfSpUD0LPozykgBp6EhmXQuO0h0EkYBu1SVluSrCFn8zV3rZpSFM4KL/09xter+7yjsAYO9r4+DfYRJBmha38hZXgJy+e9uF5pjs8Ton0snWU1KiOxUm9+zqX9XXnQllLr3CaoOJ0AQq532nbTgGdrws0G93wq3coJCDv6CP0VxTB6UFiTjlspUBtUjuzrDpQH2IEMaLz1pqpMXDFif7jjG7FXhEkx+05psVsMTletRUBh6st/SFX9ny0JkCYImQeBbcAcJC4Zfy5l6FjenVQLxRqRLkUdxnc=\" }";

		Response response = given().spec(requestSpec).body(reqBody).post("/user/keys");
		// Assertion with response specification
		response.then().spec(responseSpec);

		// Print response
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		id = response.then().extract().path("id");
		System.out.println("Id: " + id);
		Assert.assertEquals(response.getStatusCode(), 201);

	}

	
	@Test 
	public void GetRequest() {

		Response response = given().spec(requestSpec).get("/user/keys");
		System.out.println(response.getBody().asPrettyString());
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test 
	public void DeleteRequest() {

		Response response = given().spec(requestSpec).pathParam("keyId", id).delete("/user/keys/{keyId}");
		Reporter.log(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}
	
}



