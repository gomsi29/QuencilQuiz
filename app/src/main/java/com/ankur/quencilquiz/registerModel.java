package com.ankur.quencilquiz;

public class registerModel {

    String userName,email;



    public registerModel()
    {

    }

    public registerModel(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
