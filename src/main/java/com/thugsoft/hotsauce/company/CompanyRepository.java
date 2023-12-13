package com.thugsoft.hotsauce.company;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    Iterable<Company> findByNameContaining(String name);
}
