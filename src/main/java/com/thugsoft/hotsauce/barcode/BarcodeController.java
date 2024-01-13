package com.thugsoft.hotsauce.barcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barcodes")
public class BarcodeController {
    @Autowired
    private BarcodeRepository barcodeRepository;

    @GetMapping
    public Iterable<Barcode> getBarcodes() {
        return barcodeRepository.findAll();
    }

    @GetMapping("/count")
    public Long countBarcodes() {
        return barcodeRepository.count();
    }

    @GetMapping("/{id}")
    public Barcode getBarcode(@PathVariable Long id) {
        return barcodeRepository.findById(id).orElse(null);
    }
    @GetMapping("/barcode/{barcode}")
    public Barcode findByBarcodeMatching(@PathVariable String barcode) {
        return barcodeRepository.findByBarcodeMatching(barcode);
    }

    @PostMapping
    public Barcode createBarcode(@RequestBody Barcode barcode) {
        return barcodeRepository.save(barcode);
    }

    @PutMapping("/{id}")
    public Barcode updateBarcode(@PathVariable Long id, @RequestBody Barcode barcode) {
        Barcode existingBarcode = barcodeRepository.findById(id).orElse(null);
        if (existingBarcode == null) {
            return null;
        }
        existingBarcode.setBarcode(barcode.getBarcode());
        existingBarcode.setSauceId(barcode.getSauceId());
        existingBarcode.setUserId(barcode.getUserId());
        return barcodeRepository.save(existingBarcode);
    }

    @DeleteMapping("/{id}")
    public String deleteBarcode(@PathVariable Long id) {
        try {
            barcodeRepository.deleteById(id);
            return "Deleted barcode with id: " + id;
        } catch (Exception e) {
            return "Barcode not found.";
        }
    }
}
