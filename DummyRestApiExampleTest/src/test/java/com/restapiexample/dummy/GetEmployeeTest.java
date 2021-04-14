package com.restapiexample.dummy;

import com.restapiexample.dummy.dto.EmployeeDTO;
import com.restapiexample.dummy.model.ResponseBody;
import com.restapiexample.dummy.service.EmployeeService;
import com.restapiexample.dummy.service.Helpers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class GetEmployeeTest extends BaseTest {

    @Test(priority = 1)
    public static void getEmployeeById() {
        ResponseBody expectedResponse = EmployeeDTO.responseForGet(EmployeeDTO.employee());
        ResponseBody actualResponse = EmployeeService.getEmployeeById(1);

        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertNotEquals(0, actualResponse.getData().getId());
        assertEquals(expectedResponse.getData().getName(), actualResponse.getData().getName());
        assertEquals(expectedResponse.getData().getSalary(), actualResponse.getData().getSalary());
        assertEquals(expectedResponse.getData().getAge(), actualResponse.getData().getAge());
        assertEquals(expectedResponse.getData().getProfileImage(), actualResponse.getData().getProfileImage());
        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }

    @Test(priority = 2)
    public static void getEmployeeByIdNotFound() {
        Response response = EmployeeService.getEmployeeByIdResponse(Helpers.randomIntGenerator(10000, 20000));
        assertEquals(404, response.statusCode());
    }
}
