package com.thugsoft.hotsauce.company;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "website")
    private String website;

    @Column(name = "image", length = 100000, columnDefinition = "BYTEA")
    private byte[] image;

    @Column(name = "user_id")
    private Long userId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    public Company() {
    }

    public Company(String name, String description, String location,
                   String website, byte[] image, Long userId) {

        this.name = name;
        this.description = description;
        this.location = location;
        this.website = website;
        this.image = image;
        this.userId = userId;
    }

    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getLocation() { return this.location; }
    public String getWebsite() { return this.website; }
    public byte[] getImage() { return this.image; }
    public Long getUserId() { return this.userId; }
    public String getCreatedAt() { return this.createdAt.toString(); }
    public String getUpdatedAt() { return this.updatedAt.toString(); }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void setWebsite(String website) { this.website = website; }
    public void setImage(byte[] image) { this.image = image; }
    public void setUserId(Long userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", description='" + getDescription() + "'"
                + ", location='" + getLocation() + "'"
                + ", website='" + getWebsite() + "'"
                + ", image='" + getImage() + "'"
                + ", userId='" + getUserId() + "'"
                + ", createdAt='" + getCreatedAt() + "'"
                + ", updatedAt='" + getUpdatedAt() + "'"
                + "}";
    }
}
