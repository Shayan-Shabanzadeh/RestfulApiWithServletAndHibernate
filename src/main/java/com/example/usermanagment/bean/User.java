package com.example.usermanagment.bean;

import java.util.List;

public class User {
        private Long id;
        private String name;
        private String email;
        private String country;
        private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public User(Long id, String name, String email, String country , List<Address> addresses) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.country = country;
            this.addresses = addresses;
        }


        public User() {
        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}

