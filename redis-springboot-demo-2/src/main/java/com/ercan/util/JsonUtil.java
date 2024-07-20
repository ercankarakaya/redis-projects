package com.ercan.util;


import com.ercan.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ROOT_PATH = System.getProperty("user.dir");


    /**
     * JSON dosyasını belirli bir Java sınıfına dönüştürür.
     *
     * @param subPath JSON dosyasının yolu.
     * @param clazz    Dönüştürülecek sınıfın tipi.
     * @param <T>      JSON'dan dönüştürülecek sınıfın türü.
     * @return JSON dosyasından dönüştürülmüş nesne.
     */
    public static <T> T readJson(String subPath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(ROOT_PATH+subPath), clazz);
    }

    public static <T> List<T> readJsonArray(String subPath, Class<T[]> clazz) throws IOException {
        T[] array = objectMapper.readValue(new File(ROOT_PATH+subPath), clazz);
        return List.of(array);
    }
}
