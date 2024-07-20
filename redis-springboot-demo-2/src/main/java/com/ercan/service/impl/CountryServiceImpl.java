package com.ercan.service.impl;

import com.ercan.dto.CountryDto;
import com.ercan.entity.Country;
import com.ercan.mapper.CountryMapper;
import com.ercan.repository.CountryRepository;
import com.ercan.service.CountryService;
import com.ercan.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.ercan.constant.CacheConstant.CacheNames.COUNTRY_ISOs;
import static com.ercan.constant.CacheConstant.CacheNames.COUNTRY_NAMES;


@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    //    @Caching(
//            evict = {
//                    @CacheEvict(value = COUNTRY_NAMES, allEntries = true),
//                    @CacheEvict(value = COUNTRY_ISOs, allEntries = true)
//            }
//    )
    @CacheEvict(value = {COUNTRY_NAMES, COUNTRY_ISOs}, allEntries = true)
    @Override
    public CountryDto create(CountryDto countryDto) {
        Country country = countryRepository.save(countryMapper.toCountry(countryDto));
        return countryMapper.toCountryDto(country);
    }

    @Override
    public List<CountryDto> createAllCountries() {
        List<CountryDto> countryDtoList = null;
        try {
            String filePath = "/src/main/resources/static/countries.json";
            countryDtoList = JsonUtil.readJsonArray(filePath, CountryDto[].class);
        } catch (Exception ex) {
            log.error("CountryServiceImpl.createAllCountries() Error : ", ex);
        }
        List<Country> savedCountryList = countryRepository.saveAll(countryMapper.toCountryList(countryDtoList));
        return countryMapper.toCountryDtoList(savedCountryList);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryMapper.toCountryDtoList(countryRepository.findAll());
    }

    @Cacheable(COUNTRY_NAMES)
    @Override
    public List<String> getAllCountryNames() {
        return countryRepository.findAllCountryNames();
    }

    @Cacheable(COUNTRY_ISOs)
    @Override
    public List<String> getAllCountryISOs() {
        return countryRepository.findAllCountryISOs();
    }
}
