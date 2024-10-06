package ru.itmentor.spring.boot_security.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users_security", schema = "users_security_schema")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    @Column(name = "name")
    private String firstName;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "the number must consist of six digits")
    @Max(value = 1000000, message = "the number must consist of six digits")
    @Min(value = 100000, message = "the number must consist of six digits")
    @Column(name = "phone_number")
    private Integer phoneNumber;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 45, message = "the permissible size has been exceeded")
    @Column(name = "department")
    private String department;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 35, message = "the permissible size has been exceeded")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "field cannot be empty")
    @Size(min = 4, message = "min 4 characters")
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", schema = "users_security_schema")
    @NotEmpty(message = "select a role")
    private Set<Role> roles=new HashSet<>();

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phoneNumber=" + phoneNumber +
               ", department='" + department + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", roles=" + roles +
               '}';
    }

    public User(String firstName, String lastName, String department, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
