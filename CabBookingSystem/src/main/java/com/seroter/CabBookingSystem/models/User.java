package com.seroter.CabBookingSystem.models;

public class User {
    private String usernmae;
    private String gender;
    private int age = -1;

    public User(String usernmae, String gender, int age) {
        super();
        this.usernmae = usernmae;
        this.gender = gender;
        this.age = age;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
