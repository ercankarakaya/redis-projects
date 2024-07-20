package com.ercan.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheConstant {


//    private CacheConstant(){
//        throw new UnsupportedOperationException("Utility class should not be instantiated.");
//    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CacheNames {
        public static final String COUNTRY_NAMES = "COUNTRY_NAMES";
        public static final String COUNTRY_ISOs = "COUNTRY_ISOs";
    }
}
