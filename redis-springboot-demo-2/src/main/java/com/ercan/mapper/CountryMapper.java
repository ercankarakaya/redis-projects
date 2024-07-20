package com.ercan.mapper;

import com.ercan.dto.CountryDto;
import com.ercan.entity.Country;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Named("toCountry")
    @Mapping(target = "id",ignore = true)
    Country toCountry(CountryDto countryDto);

    @Named("toCountryDto")
    CountryDto toCountryDto(Country country);

    @IterableMapping(qualifiedByName = "toCountry")
    List<Country> toCountryList(List<CountryDto> countryDtoList);
    @IterableMapping(qualifiedByName = "toCountryDto")
    List<CountryDto> toCountryDtoList(List<Country> countryList);
}
