package com.example.demo.dto;

import javax.validation.constraints.*;

public class SignUpFormDto {

    @Size(min = 5, max = 45 ,message = "Last Name with size 5-45")

    private String firstName;
    @Size(min = 5, max = 45 ,message = "Last Name with size 5-45")

    private String lastName;
    @Pattern(regexp = "^0\\d{9}$" , message = "phone number size is 10")

    private String phoneNumber;

    @Min(value = 18, message = "Age must be 18 up")

    private int age;
    @Pattern(regexp = "^\\w+@\\w+.com$", message = "Input email with @gmail.com")
    private String email;

    public SignUpFormDto( String firstName, String lastName, String phoneNumber, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    public SignUpFormDto() {
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
}
