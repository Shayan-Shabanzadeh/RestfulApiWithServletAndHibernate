package com.example.usermanagment.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User extends Entity{
        private String name;
        private String email;
        private String country;
        private List<Address> addresses;
        private Set<Roll> rolls;


    public User(Long id, String name, String email, String country, List<Address> addresses, Set<Roll> rolls) {
        super(id);
        this.name = name;
        this.email = email;
        this.country = country;
        this.addresses = addresses;
        this.rolls = rolls;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    public Set<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(Set<Roll> rolls) {
        this.rolls = rolls;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", addresses=" + addresses +
                ", rolls=" + rolls +
                '}';
    }
}

