package com.example.demoSpringBoot.domain;

/**
 * Controller to check if a word is a palindrome.
 * @author Jorge Correyero
 */
public class Customer {
    // Attributes
    private int id;
    private String name;
    private String username;
    private String password;

    // Constructors
    /**
     * Parameterized constructor.
     *
     * @param id numeric identifier for the class
     * @param name real name of the customer
     * @param username account name for the customer
     * @param password access key for the account
     */
    public Customer(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Setters and getters for every attribute in this class
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
