package com.ercan.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    //@JsonIgnore
    private Long id;
    private String iso;
    private String name;
    private String phoneCode;
}
