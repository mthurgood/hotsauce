package com.thugsoft.hotsauce.barcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
    default Barcode findByBarcodeMatching(String barcode) {
        return findAll().stream().filter(b -> b.getBarcode().equals(barcode)).findFirst().orElse(null);
    }
}