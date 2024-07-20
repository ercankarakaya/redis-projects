package com.ercan.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiConstant {


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Country {
        public static final String BASE_URL = "/country";
        public static final String COUNTRY_NAMES = "/names";

        public static final String COUNTRY_ISOs = "/iso";
        public static final String CREATE_ALL = "/createAll";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Cache {
        public static final String BASE_URL = "/cache";
        public static final String EVICT_COUNTRY_NAMES = "/names/evict";
        public static final String EVICT_COUNTRY_ISOS = "/iso/evict";
    }
}
