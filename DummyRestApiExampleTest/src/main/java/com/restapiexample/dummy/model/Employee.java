package com.restapiexample.dummy.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Employee {

    private int id;
    private String name;
    private int salary;
    private int age;
    private String profileImage;

    public Employee() {
    }

    @JsonCreator
    public Employee(@JsonProperty("id") int id, @JsonProperty("employee_name") String name,
                            @JsonProperty("employee_salary") int salary, @JsonProperty("employee_age") int age,
                            @JsonProperty("profile_image") String profileImage) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.profileImage = profileImage;
    }

    public int getId() {
        return this.id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Employee setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public Employee setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        return this;
    }
}
