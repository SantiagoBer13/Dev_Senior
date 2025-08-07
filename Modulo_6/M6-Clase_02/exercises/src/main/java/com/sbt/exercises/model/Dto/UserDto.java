package com.sbt.exercises.model.Dto;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean active;

    public UserDto(Long id, String name, String email, String password, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserDto [name=" + name + ", email=" + email + ", password=" + password + ", active=" + active + "]";
    }

}
