package com.thugsoft.hotsauce.user;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username", unique = true)
    private String username;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @CreationTimestamp
    @Column(name="created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Instant updatedAt;

    @Column(name="status")
    private String status;

    public User() {
    }

    public User(String username, String email, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = "created";
        System.out.println("User created: " + this.toString());
    }

    public Long getId() { return this.id; }
    public String getUsername() {
        return this.username;
    }
    public String getEmail() {
        return this.email;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getCreatedAt() { return this.createdAt.toString(); }
    public String getUpdatedAt() { return this.updatedAt.toString(); }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    void setStatus(String status) { this.status = status; }
    String getStatus() { return this.status; }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", username='" + getUsername() + "'"
                + ", email='" + getEmail() + "'"
                + ", firstName='" + getFirstName() + "'"
                + ", lastName='" + getLastName() + "'"
                + ", status='" + getStatus() + "'"
                + ", createdAt='" + getCreatedAt() + "'"
                + ", updatedAt='" + getUpdatedAt() + "'"
                + "}";
    }
}
