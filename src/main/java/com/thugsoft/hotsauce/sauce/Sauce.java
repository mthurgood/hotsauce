package com.thugsoft.hotsauce.sauce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Sauce")
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

    // TODO: this should be a foreign key to the peppers table
    // TODO: this should be a one-to-many relationship
    // @Column(name = "pepper_id")
    // private Long pepperId;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "image", length = 100000, columnDefinition = "BYTEA")
    private byte[] image;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "rating_id")
    private Long ratingId;
    @CreationTimestamp
    @Column(name="created_at")
    private String createdAt;
    @UpdateTimestamp
    @Column(name="updated_at")
    private String updatedAt;

    public Sauce() {
    }

    public Sauce(String name, long scoville, String description,
                 String ingredients, byte[] image, Long userId, Long ratingId, Long companyId) {
        this.name = name;
        this.scoville = scoville;
        this.description = description;
        this.ingredients = ingredients;
        this.image = image;
        this.userId = userId;
        this.ratingId = ratingId;
        this.companyId = companyId;
        this.createdAt = "now";
        this.updatedAt = "now";
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return this.name; }
    public long getScoville() { return this.scoville; }
    public String getDescription() { return this.description; }
    // public Long getPepperId() { return this.pepperId; }
    public String getIngredients() { return this.ingredients; }
    public byte[] getImage() { return this.image; }
    public Long getUserId() { return this.userId; }
    public Long getCompanyId() { return this.companyId; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public void setName(String name) { this.name = name; }
    public void setScoville(long scoville) { this.scoville = scoville; }
    public void setDescription(String description) { this.description = description; }
    // public void setPepperId(Long pepperId) { this.pepperId = pepperId; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setImage(byte[] image) { this.image = image; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public void setRatingId(Long ratingId) { this.ratingId = ratingId; }
    public Long getRatingId() { return this.ratingId; }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", scoville='" + getScoville() + "'"
                + ", description='" + getDescription() + "'"
                + ", ingredients='" + getIngredients() + "'"
                + ", image='" + getImage() + "'"
                + ", userId='" + getUserId() + "'"
                + ", companyId='" + getCompanyId() + "'"
                + ", createdAt='" + getCreatedAt() + "'"
                + ", updatedAt='" + getUpdatedAt() + "'"
                + "}";
    }
}
