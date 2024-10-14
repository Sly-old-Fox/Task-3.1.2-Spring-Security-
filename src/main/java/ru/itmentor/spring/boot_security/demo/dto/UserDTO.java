package ru.itmentor.spring.boot_security.demo.dto;

import jakarta.validation.constraints.*;

public class UserDTO {

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    private String firstName;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    private String lastName;

    @NotNull(message = "the number must consist of six digits")
    @Max(value = 1000000, message = "the number must consist of six digits")
    @Min(value = 100000, message = "the number must consist of six digits")
    private Integer phoneNumber;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 45, message = "the permissible size has been exceeded")
    private String department;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    private String username;

    @NotBlank(message = "field cannot be empty")
    @Size(min = 4, message = "min 4 characters")
    private String password;

    @NotEmpty(message = "select a role")
    private String[] roles;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
