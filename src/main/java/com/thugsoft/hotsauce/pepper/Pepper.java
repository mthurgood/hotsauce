package com.thugsoft.hotsauce.pepper;

import jakarta.persistence.*;

@Entity
@Table(name = "peppers")
public class Pepper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image", length = 100000, columnDefinition = "LONGBLOB")
    private String image;
@Column(name = "user_id")
    private Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String updatedAt;

    public Pepper() {
    }

    public Pepper(String name, String description, String image, Long userId) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.userId = userId;
        this.createdAt = "now";
        this.updatedAt = "now";
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getImage() { return this.image; }
    public Long getUserId() { return this.userId; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setImage(String image) { this.image = image; }
    public void setUserId(Long userId) { this.userId = userId; }
}
