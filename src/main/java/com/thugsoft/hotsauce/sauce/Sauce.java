package com.thugsoft.hotsauce.sauce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "sauce")
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

    @Column(name = "ingredients")
    private String ingredients;

    // TODO: add allergens
    @Column(name = "allergens")
    private String allergens;

    @Column(name = "image", length = 100000, columnDefinition = "BYTEA")
    private byte[] image;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "company_id")
    private Long companyId;

    @CreationTimestamp
    @Column(name="created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Instant updatedAt;

    public Sauce() {
    }

    public Sauce(String name, long scoville, String description, String allergens,
                 String ingredients, byte[] image, Long userId, Long companyId) {
        this.name = name;
        this.scoville = scoville;
        this.description = description;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.image = image;
        this.userId = userId;
        this.companyId = companyId;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return this.name; }
    public long getScoville() { return this.scoville; }
    public String getDescription() { return this.description; }
    public String getIngredients() { return this.ingredients; }
    public byte[] getImage() { return this.image; }
    public Long getUserId() { return this.userId; }
    public Long getCompanyId() { return this.companyId; }
    public Instant getCreatedAt() { return this.createdAt; }
    public Instant getUpdatedAt() { return this.updatedAt; }
    public void setName(String name) { this.name = name; }
    public void setScoville(long scoville) { this.scoville = scoville; }
    public void setDescription(String description) { this.description = description; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setImage(byte[] image) { this.image = image; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public void setAllergens(String allergens) { this.allergens = allergens; }
    public String getAllergens() { return this.allergens; }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", scoville='" + getScoville() + "'"
                + ", description='" + getDescription() + "'"
                + ", ingredients='" + getIngredients() + "'"
                + ", allergens='" + getAllergens() + "'"
                + ", image='" + getImage() + "'"
                + ", userId='" + getUserId() + "'"
                + ", companyId='" + getCompanyId() + "'"
                + ", createdAt='" + getCreatedAt() + "'"
                + ", updatedAt='" + getUpdatedAt() + "'"
                + "}";
    }
}
