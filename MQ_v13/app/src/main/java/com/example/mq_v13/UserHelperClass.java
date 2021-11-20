package com.example.mq_v13;

public class UserHelperClass {
    String id, password, email, carplate;

    public UserHelperClass() {
    }

    public UserHelperClass(String id, String password, String email, String carplate) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.carplate = carplate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }
}
