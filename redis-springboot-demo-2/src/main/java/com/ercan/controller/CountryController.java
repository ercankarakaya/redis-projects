package com.ercan.controller;

import com.ercan.constant.ApiConstant;
import com.ercan.dto.CountryDto;
import com.ercan.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.Country.BASE_URL)
public class CountryController {

    private final CountryService countryService;


    @PostMapping
    public ResponseEntity<CountryDto> insertCountry(@RequestBody CountryDto countryDto){
        return ResponseEntity.ok(countryService.create(countryDto));
    }
    @PostMapping(ApiConstant.Country.CREATE_ALL)
    public List<CountryDto> createAllCountries() {
        return countryService.createAllCountries();
    }

    @GetMapping(ApiConstant.Country.COUNTRY_NAMES)
    public List<String> getAllCountryNames() {
        return countryService.getAllCountryNames();
    }

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping(ApiConstant.Country.COUNTRY_ISOs)
    public List<String> getAllCountryISOs() {
        return countryService.getAllCountryISOs();
    }
}
