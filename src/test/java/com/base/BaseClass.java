package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.pojo.AddAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqspec;
	Response response;

	public String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Property\\config.properties");

		properties.load(stream);
		Object obj = properties.get(key);
		String value = (String) obj;
		return value;

	}

	public void basicAuth(String username, String password) {
		reqspec.auth().preemptive().basic(username, password);

	}

	public void addHeader(String key, String value) {

		reqspec = RestAssured.given();
		reqspec = reqspec.header(key, value);

	}

	public void queryParam(String key, String value) {
		reqspec = reqspec.queryParam(key, value);

	}

	public void pathParam(String key, String value) {
		reqspec = reqspec.pathParam(key, value);
	}

	public void addBody(Object body) {
		reqspec = reqspec.body(body);

	}

	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}

	public void addheaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);
	}

	public Response requestType(String reqType, String endpoint) {

		switch (reqType) {
		case "GET":
			response = reqspec.get(endpoint);
			break;
		case "POST":
			response = reqspec.post(endpoint);
			break;
		case "PUT":
			response = reqspec.put(endpoint);
			break;
		case "DELETE":
			response = reqspec.delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}

	public void formData() {
		reqspec = reqspec.multiPart("profile_picture", new File("C:\\Users\\admin\\Downloads\\Api"));

	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public ResponseBody getBody() {
		ResponseBody body = response.getBody();
		return body;
	}

	public String getBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getBodyAsPretty(Response response2) {
		String asPrettyString = response.asString();
		return asPrettyString;
	}
}
