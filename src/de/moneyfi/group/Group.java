package de.moneyfi.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Group {
    private String hashpassword;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPassword() {
        return hashpassword;
    }
    public Group setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
        return this;
    }
}
