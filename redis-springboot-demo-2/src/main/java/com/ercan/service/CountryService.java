package com.ercan.service;

import com.ercan.dto.CountryDto;
import com.ercan.entity.Country;

import java.io.IOException;
import java.util.List;

public interface CountryService {

    CountryDto create(CountryDto countryDto);

    List<CountryDto> createAllCountries();

    List<CountryDto> getAllCountries();

    List<String> getAllCountryNames();

    List<String> getAllCountryISOs();
}
