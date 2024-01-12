package com.thugsoft.hotsauce.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public Iterable<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/count")
    public Long countCompanies() {
        return companyRepository.count();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company existingCompany = companyRepository.findById(id).orElse(null);
        if (existingCompany == null) {
            return null;
        }
        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());
        existingCompany.setLocation(company.getLocation());
        existingCompany.setWebsite(company.getWebsite());
        existingCompany.setImage(company.getImage());
        return companyRepository.save(existingCompany);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        try {
            companyRepository.deleteById(id);
            return "Deleted company with id: " + id;
        } catch (Exception e) {
            return "Company not found.";
        }
    }

    @GetMapping("/search")
    public Iterable<Company> searchCompanies(@RequestParam String name) {
        return companyRepository.findByNameContaining(name);
    }

}
