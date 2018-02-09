package de.moneyfi.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String hashpassword;

    public int getId() {
        return id;
    }
    public User setId(int id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public User setName(String name) {
        this.name = name;
        return this;
    }
    public String getHashPassword() {
        return hashpassword;
    }
    public User setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
        return this;
    }
}
