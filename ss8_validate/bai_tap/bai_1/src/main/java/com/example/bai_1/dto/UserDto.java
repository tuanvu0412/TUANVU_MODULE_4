package com.example.bai_1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    @Size(min = 5, max = 45, message = "tên phải lớn hơn 5 ký tự và nhỏ hơn 45 ký tự")
    private String firstName;
    @Size(min = 5, max = 45, message = "tên phải lớn hơn 5 ký tự và nhỏ hơn 45 ký tự")
    private String lastName;
    @Min(11)
    private String phoneNumber;
    @Min(value = 18, message = "lớn hơn hoặc bằng 18")
    private int age;
    @Email(message = "email không hợp lệ")
    @NotBlank(message = "email không được đê trống")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
