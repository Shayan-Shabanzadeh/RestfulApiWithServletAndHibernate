package com.example.usermanagment.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Set;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Roll extends Entity{
    private String rollName;
    private Set<User> users;

    public Roll(Long id, String rollName, Set<User> users) {
        super(id);
        this.rollName = rollName;
        this.users = users;
    }

    public Roll() {

    }


    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "id=" + id +
                ", rollName='" + rollName + '\'' +
                '}';
    }
}
