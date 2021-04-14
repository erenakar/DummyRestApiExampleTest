package com.restapiexample.dummy.dto;

import com.restapiexample.dummy.model.Employee;
import com.restapiexample.dummy.model.ResponseBody;
import com.restapiexample.dummy.service.Helpers;

public class EmployeeDTO {

    public static Employee employee() {
        return new Employee()
                .setId(1)
                .setName("Tiger Nixon")
                .setSalary(320800)
                .setAge(61)
                .setProfileImage("");
    }

    public static Employee randomEmployee() {
        return new Employee()
                .setName(Helpers.randomStringGenerator())
                .setSalary(Helpers.randomIntGenerator(100000, 200000))
                .setAge(Helpers.randomIntGenerator(25, 50));
    }

    public static Employee emptyEmployee() {
        return new Employee();
    }

    public static ResponseBody responseForGet(Employee employee) {
        return new ResponseBody()
                .setStatus("success")
                .setData(employee)
                .setMessage("Successfully! Record has been fetched.");
    }

    public static ResponseBody responseForPost(Employee employee) {
        return responseForGet(employee).setMessage("Successfully! Record has been added.");
    }
}
