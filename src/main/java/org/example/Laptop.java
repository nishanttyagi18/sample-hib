
package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int id;
    private String lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
