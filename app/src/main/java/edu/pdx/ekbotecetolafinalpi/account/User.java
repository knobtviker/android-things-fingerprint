package edu.pdx.ekbotecetolafinalpi.account;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private Timestamp created;
    public static final String COLLECTION = "users";

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
