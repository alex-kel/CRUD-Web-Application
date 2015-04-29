package com.fs.javalab.webapplication.model;


public class User {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
