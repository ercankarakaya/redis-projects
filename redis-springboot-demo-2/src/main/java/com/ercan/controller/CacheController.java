package com.ercan.controller;


import com.ercan.constant.ApiConstant;
import com.ercan.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ercan.constant.CacheConstant.CacheNames.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstant.Cache.BASE_URL)
public class CacheController {

    private final CacheService cacheService;

    @DeleteMapping(ApiConstant.Cache.EVICT_COUNTRY_NAMES)
    public String evictCountryNamesCache() {
        cacheService.evictCacheValues(COUNTRY_NAMES);
        return "Successful for cache " + COUNTRY_NAMES;
    }

    @DeleteMapping(ApiConstant.Cache.EVICT_COUNTRY_ISOS)
    public String evictCountryISOsCache() {
        cacheService.evictCacheValues(COUNTRY_ISOs);
        return "Successful for cache " + COUNTRY_ISOs;
    }
}
