package com.example.usermanagment.bean;

import java.util.Set;

public class Address {
    private Long id;
    private String address;
    private User user;
    private Set<Roll> rolls;


    public Address() {}

    public Address(Long id, String address, User user, Set<Roll> rolls) {
        this.id = id;
        this.address = address;
        this.user = user;
        this.rolls = rolls;
    }

    public Set<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(Set<Roll> rolls) {
        this.rolls = rolls;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
