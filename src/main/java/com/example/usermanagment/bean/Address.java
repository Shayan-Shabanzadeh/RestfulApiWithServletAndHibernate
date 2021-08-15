package com.example.usermanagment.bean;

public class Address {
    private Long id;
    private String address;
    private Long userId;


    public Address() {}

    public Address(Long id, String address, Long userId) {
        this.id = id;
        this.address = address;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
