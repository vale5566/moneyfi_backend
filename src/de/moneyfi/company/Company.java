package de.moneyfi.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String hashpassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPassword() {
        return hashpassword;
    }
    public Company setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
        return this;
    }
}
