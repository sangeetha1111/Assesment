package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.Assert;

import UI.Findelements;

public class steps {
	
	RequestSpecification Req;
	Response res;
	ValidatableResponse val;
	public WebDriver dr;
	 public Findelements f;
	
	@Given("Baseurl")
	public void baseurl() {
	    System.out.println("BaseURL");
	    
	}

	@When("get users")
	public void get_users() {
		  res=given()
	  .when().get("https://reqres.in/api/users?page=2");

	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
			res.then().log().all();
	}

	@When("get specific user")
	public void get_specific_user() {
		 res=given()
	  .when().get("https://reqres.in/api/users/2");
	  
	}

	@Then("validate")
	public void validate() {
		res.then().log().all();
	}	
	
	@When("user not found")
	public void user_not_found() {
	  res=given()
	  .when().get("https://reqres.in/api/users/23");
	  
	}

	@Then("Verify")
	public void Verify (){
	
		int code=res.getStatusCode();
		Assert.assertEquals(404,code);
     res.then().log().all();
	}	
	
		
	@Given("headerinfo")
	public void headerinfo()
	
	{
		Map<String,String> data=new HashMap<String,String>();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		Req=given().contentType("application/json").body(data);
	}
	@When("create")
	public void create() {
	
	  res=Req.
	  when().post("https://reqres.in/api/users");
	  
	}
	
	
	@Then("check")
	public void check (){
		
	res.then().assertThat().statusCode(201);
	res.then().assertThat().body("name", equalTo("morpheus"));
	res.then().log().all();
	}
	
	@Given("update")
	public void update()
		{
		Map<String,String> data=new HashMap<String,String>();
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		
		Req=given().contentType("application/json").body(data);
	}
	@When("updaterecord")
	public void updaterecord() {
	
	  res=Req.
	  when().put("https://reqres.in/api/users/2");
	  
	}
	
	
	@Then("check1")
	public void check1 (){
		
	res.then().assertThat().statusCode(200);
	res.then().assertThat().body("name", equalTo("morpheus"));
	res.then().assertThat().body("job", equalTo("zion resident"));
	res.then().log().all();
	}	
	
	@When("delete")
	public void delete() {
	
	  res=
	  when().delete("https://reqres.in/api/users/2");
	}
	
	@Then("check2")
	public void check2 (){
		
	res.then().assertThat().statusCode(204);
	res.then().log().all();
	}	
	//@Given("Launch")
	@Before
	public void Launch()
	{
		System.setProperty("webdriver.edge.driver","./src/test/java/Driver/msedgedriver.exe");
		dr=new EdgeDriver();
		dr.manage().window().maximize();
		 f=new Findelements(dr);
		
	}
	@When("Click")
	public void Click()
	{
		
		dr.get("https://reqres.in/");
		f.click();
		
	}
	@Then("RequestURL")
	public void RequestURL() 
	{
		String s=f.verifyreq();
        Assert.assertEquals("/api/users?page=2", s);		
	
	}
	
	@And("Responsecode")
	public void Responsecode()
	{
	
		String s2=f.verifyres();
	    Assert.assertEquals("200", s2);
	}
	
	
	@Then("SupportButton")
	public void SupportButton()
	{
		
		Boolean b1=f.supportbutton();
		Assert.assertTrue(b1);
		
	}
	

	@Then("Onetimepayment")
	public void Onetimepayment()
	{
		
		Boolean b2=f.Onetimepayment();
		Assert.assertTrue(b2);
	}	
	
	@And("Monthlysupport")
	public void Monthlysupport()
	{
		
		Boolean b2=f.Monthlysupport();
		Assert.assertTrue(b2);
	}	
	

	@Then("Upgrade")
	public void Upgrade()
	{
		
		Boolean b3=f.Monthlysupport();
		Assert.assertTrue(b3);
	}	
	
	@After
	public void close()
	{
		dr.close();
		
	}
	
	
}
