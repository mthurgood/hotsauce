package com.thugsoft.hotsauce.sauce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "sauces")
public class Sauce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "scoville")
    private long scoville;
    @Column(name = "description")
    private String description;

    // this should be a foreign key to the peppers table
    // this should be a one-to-many relationship
    @Column(name = "pepper_id")
    private Long pepperId;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "image", length = 100000, columnDefinition = "BYTEA")
    private byte[] image;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
    @Column(name = "updated_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String updatedAt;

    public Sauce() {
    }

    public Sauce(String name, long scoville, String description, Long pepperId,
                 String ingredients, byte[] image, Long userId, Long companyId) {
        this.name = name;
        this.scoville = scoville;
        this.description = description;
        this.pepperId = pepperId;
        this.ingredients = ingredients;
        this.image = image;
        this.userId = userId;
        this.companyId = companyId;
        this.createdAt = "now";
        this.updatedAt = "now";
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return this.name; }
    public long getScoville() { return this.scoville; }
    public String getDescription() { return this.description; }
    public Long getPepperId() { return this.pepperId; }
    public String getIngredients() { return this.ingredients; }
    public byte[] getImage() { return this.image; }
    public Long getUserId() { return this.userId; }
    public Long getCompanyId() { return this.companyId; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public void setName(String name) { this.name = name; }
    public void setScoville(long scoville) { this.scoville = scoville; }
    public void setDescription(String description) { this.description = description; }
    public void setPepperId(Long pepperId) { this.pepperId = pepperId; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setImage(byte[] image) { this.image = image; }
    public void setUserId(Long userId) { this.userId = userId; }
}
