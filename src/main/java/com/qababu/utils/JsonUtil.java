package com.qababu.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Map;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static Map<String, String> getJsonDataAsMap(String jsonFileName){
        String filePath = System.getProperty("user.dir")+"/src/test/resources/"+jsonFileName+".json";
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {});
    }
}
