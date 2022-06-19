package com.pojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OmrBranch extends BaseClass {
	String logtoken;
	int address_id;

	@Test(priority = 1)
	public void login() throws IOException {

		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyValue("username"), getPropertyValue("password"));
		Response response = requestType("POST", Endpoints.LOGIN);
		int StatusCode = getStatusCode(response);
		System.out.println(StatusCode);

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);

	}

	@Test(priority = 2)
	public void createAddress() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);
		addheaders(headers);

		AddAddress_Input_Pojo addinputpojo = new AddAddress_Input_Pojo("Karthick", "Kumar", "9941505567", "s", 10, 10,
				10, "600076", "s", "s");
		addBody(addinputpojo);

		// req type
		Response response = requestType("POST", Endpoints.ADDADDRESS);
		System.out.println(getStatusCode(response));
		AddAddress_Output_Pojo addaddrssoutputpojo = response.as(AddAddress_Output_Pojo.class);

		address_id = addaddrssoutputpojo.getAddress_id();
		System.out.println(address_id);

	}

	@Test(priority = 3)
	public void updateAddress() {

		// 1.headers
		List<Header> uh = new ArrayList<>();

		Header uh1 = new Header("Content-Type", "application/json");
		Header uh2 = new Header("Authorization", "Bearer " + logtoken);
		uh.add(uh1);
		uh.add(uh2);

		Headers headers = new Headers(uh);
		addheaders(headers);

		// (String address_id, String first_name, String last_name, String mobile,
		// String apartment, int state, int city, int country, String zipcode, String
		// address,
		// String address_type) //

		UpdateAddress_Input_Pojo UpAddressinputpojo = new UpdateAddress_Input_Pojo("3", "Mani", "Kandan", "8056267151",
				"apartment", 6, 6, 6, "600094", "Kolathur", "home");
		addBody(UpAddressinputpojo);

		// req type
		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);
		System.out.println(getStatusCode(response));

		UpdateAddress_Output_Pojo updateaddrssoutput = response.as(UpdateAddress_Output_Pojo.class);
		String message = updateaddrssoutput.getMessage();
		System.out.println(message);

	}

	@Test(priority = 4)

	public void getUserAddress() {

		List<Header> ah = new ArrayList<>();
		Header ah1 = new Header("Content-Type", "application/json");
		Header ah2 = new Header("Authorization", "Bearer " + logtoken);
		ah.add(ah1);
		ah.add(ah2);

		Headers headers = new Headers(ah);
		addheaders(headers);

		Response response = requestType("GET", Endpoints.GETADDRESS);
		System.out.println(getStatusCode(response));

		GetAddress_Output_Pojo getaddressoutput = response.as(GetAddress_Output_Pojo.class);
		String message = getaddressoutput.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK", "Verify get address message field Contains OK");

	}

	@Test(priority = 5)

	public void deleteUserAddress() {

		List<Header> ah = new ArrayList<>();
		Header dh1 = new Header("Content-Type", "application/json");
		Header dh2 = new Header("Authorization", "Bearer " + logtoken);
		ah.add(dh1);
		ah.add(dh2);

		Headers headers = new Headers(ah);
		addheaders(headers);

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(String.valueOf(address_id));
		addBody(deleteAddress_Input_Pojo);
		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);
		System.out.println(getStatusCode(response));

		DeleteAddress_Output_pojo deleteaddressoutput = response.as(DeleteAddress_Output_pojo.class);
		String message = deleteaddressoutput.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify delete message");

	}
	@Test(priority = 6)
	
	public void profilePicture() {
       //Header
		
		List<Header> ph = new ArrayList<>();
		Header ph1 = new Header("Content-Type", "multipart/form_data");
		Header ph2 = new Header("Authorization", "Bearer " + logtoken);
		ph.add(ph1);
		ph.add(ph2);
		
		Headers headers = new Headers(ph);
		addheaders(headers);
		
		formData();
		Response response = requestType("POST", Endpoints.PROFILEPICTURE);
		System.out.println(response);
		
		
		
		

		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
