package com.restapiexample.dummy.service;

import com.restapiexample.dummy.model.Employee;
import com.restapiexample.dummy.model.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmployeeService {

    private static final String url = "http://dummy.restapiexample.com";

    public static Response createEmployeeResponse(Employee employee) {
        Response response = RestAssured.given()
                .when().header("Content-Type", "application/json").body(employee)
                .post(url + "/api/v1/create");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println(response.getBody().asString());

        return response;
    }

    public static ResponseBody createEmployee(Employee employee) {
        return createEmployeeResponse(employee)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(ResponseBody.class);
    }

    public static Response getEmployeeByIdResponse(int id) {
        Response response = RestAssured.given()
                .when().get(url + "/api/v1/employee/{id}", id);

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println(response.getBody().asString());

        return response;
    }

    public static ResponseBody getEmployeeById(int id) {
        return getEmployeeByIdResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(ResponseBody.class);
    }
}
