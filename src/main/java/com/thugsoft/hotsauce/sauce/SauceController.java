package com.thugsoft.hotsauce.sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sauces")
public class SauceController {
    @Autowired
    private SauceRepository sauceRepository;

    @GetMapping
    public Iterable<Sauce> getSauces() {
        return sauceRepository.findAll();
    }

    @GetMapping("/count")
    public Long countSauces() {
        return sauceRepository.count();
    }

    @GetMapping("/{id}")
    public Sauce getSauceById(@PathVariable Long id) {
        return sauceRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Sauce createSauce(@RequestBody Sauce sauce) {
        return sauceRepository.save(sauce);
    }

    @PutMapping("/{id}")
    public Sauce updateSauce(@PathVariable Long id, @RequestBody Sauce sauce) {
        Sauce existingSauce = sauceRepository.findById(id).orElse(null);
        if (existingSauce == null) {
            return null;
        }
        existingSauce.setName(sauce.getName());
        existingSauce.setScoville(sauce.getScoville());
        existingSauce.setIngredients(sauce.getIngredients());
        existingSauce.setCompanyId(sauce.getCompanyId());
        existingSauce.setRatingId(sauce.getRatingId());
        return sauceRepository.save(existingSauce);
    }

    @DeleteMapping("/{id}")
    public String deleteSauce(@PathVariable Long id) {
        try {
            sauceRepository.deleteById(id);
            return "Deleted sauce with id: " + id;
        } catch (Exception e) {
            return "Sauce not found.";
        }
    }

}
