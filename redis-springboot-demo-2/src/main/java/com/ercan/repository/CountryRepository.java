package com.ercan.repository;

import com.ercan.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c.name FROM Country c ORDER BY c.name")
    List<String> findAllCountryNames();

    @Query("SELECT c.iso FROM Country c ORDER BY c.iso")
    List<String> findAllCountryISOs();
}
