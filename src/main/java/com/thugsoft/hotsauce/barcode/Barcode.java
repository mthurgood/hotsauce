package com.thugsoft.hotsauce.barcode;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "barcode")
public class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // barcode
    // we can only support linear barcodes (UPC or EAN)
    // UPC-A, UPC-E, EAN-8, EAN-13
    // UPC-A: 12 digits (1-digit product type, 5-digit manufacturer, 5-digit product code, 1 check digit)
    // UPC-E: 8 digits (1-digit product type, 6-digit manufacturer/product, 1 check digit (mod 10))
    // EAN-8: 8 digits (shortened version of EAN-13
    // EAN-13: 13 digits (3-country code, 9-digit manufacturer/product, 1 check digit)
    // all of these only use the digits 0-9
    @Column(name="barcode", unique = true)
    private String barcode;
    @Column(name = "sauce_id")
    private Long sauceId;
    @Column(name = "user_id")
    private Long userId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    public Barcode() {
    }

    public Barcode(String barcode, Long sauceId, Long userId) {
        this.barcode = barcode;
        this.sauceId = sauceId;
        this.userId = userId;
    }

    public Long getId() { return this.id; }

    public String getBarcode() { return this.barcode; }

    public Long getSauceId() { return this.sauceId; }

    public Long getUserId() { return this.userId; }

    public String getCreatedAt() { return this.createdAt.toString(); }

    public String getUpdatedAt() { return this.updatedAt.toString(); }

    public void setBarcode(String barcode) { this.barcode = barcode; }

    public void setSauceId(Long sauceId) { this.sauceId = sauceId; }

    public void setUserId(Long userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "Barcode{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", sauceId=" + sauceId +
                ", userId=" + userId +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
