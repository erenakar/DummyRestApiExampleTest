package com.restapiexample.dummy;

import com.restapiexample.dummy.dto.EmployeeDTO;
import com.restapiexample.dummy.model.Employee;
import com.restapiexample.dummy.model.ResponseBody;
import com.restapiexample.dummy.service.EmployeeService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CreateEmployeeTest extends BaseTest {

    @Test(priority = 1, invocationCount = 2)
    public static void createEmployee() {
        Employee employee = EmployeeDTO.randomEmployee();
        ResponseBody expectedEmployeeResponse = EmployeeDTO.responseForPost(employee);
        ResponseBody actualEmployeeResponse = EmployeeService.createEmployee(employee);

        assertEquals(expectedEmployeeResponse.getStatus(), actualEmployeeResponse.getStatus());
        assertNotEquals(0, actualEmployeeResponse.getData().getId());
        assertEquals(expectedEmployeeResponse.getData().getName(), actualEmployeeResponse.getData().getName());
        assertEquals(expectedEmployeeResponse.getData().getSalary(), actualEmployeeResponse.getData().getSalary());
        assertEquals(expectedEmployeeResponse.getData().getAge(), actualEmployeeResponse.getData().getAge());
        assertEquals(expectedEmployeeResponse.getMessage(), actualEmployeeResponse.getMessage());
    }

    @Test(priority = 2)
    public static void createEmployeeWithEmptyBody() {
        Response response = EmployeeService.createEmployeeResponse(EmployeeDTO.emptyEmployee());
        assertEquals(400, response.statusCode());
    }
}
