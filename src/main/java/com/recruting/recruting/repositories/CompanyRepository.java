package com.recruting.recruting.repositories;


import com.recruting.recruting.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getCompanyByAddress(String address);
}
