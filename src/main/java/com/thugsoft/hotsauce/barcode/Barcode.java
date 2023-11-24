package com.thugsoft.hotsauce.barcode;

import jakarta.persistence.*;

@Entity
@Table(name = "barcodes")
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
    private String barcode;
    @Column(name = "sauce_id")
    private Long sauceId;
    @Column(name = "user_id")
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String updatedAt;
}
