package com.code;

public class User {

    private static int countID = 0;
    private String name;
    private String email;
    private String occupation;
    private int id;

    public User(String name, String email, String occupation) {
        countID += 1;
        this.id = countID;
        this.name = name;
        this.email = email;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
