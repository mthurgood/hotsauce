package com.thugsoft.hotsauce.rating;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sauce_id")
    private Long sauceId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;

    @Column(name = "updated_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String updatedAt;

    public Rating() {
    }

    public Rating(Long sauceId, Long userId, int rating) {
        this.sauceId = sauceId;
        this.userId = userId;
        this.rating = rating;
        this.createdAt = "now";
        this.updatedAt = "now";
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public Long getSauceId() { return this.sauceId; }
    public Long getUserId() { return this.userId; }
    public int getRating() { return this.rating; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }
    public void setSauceId(Long sauceId) { this.sauceId = sauceId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setRating(int rating) { this.rating = rating; }
}
