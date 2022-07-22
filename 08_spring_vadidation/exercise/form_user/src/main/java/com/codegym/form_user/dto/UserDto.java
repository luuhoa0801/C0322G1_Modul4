package com.codegym.form_user.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserDto {
    private Integer id;

    @Pattern(regexp = "^[A-Z]\\w{5,300}$", message = "sai định dạng firstName ")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "^[A-Z]\\w{3,300}$", message = "sai định dạng lastName")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "^090[0-9]{7}$", message = "sai định dạng,phải là 090...")
    private String phone;

    @NotNull(message = "không để trống")
    @Min(value = 18, message = "không được nhỏ hơn 18t")
    @Max(value = 100, message = "không được quá 100t")
    private Integer age;

    @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "sai đinh dạng,phải đúng định dạng email")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
