package base;

import utilities.JsonUtil;

import java.util.Map;

public class BaseClass {
    public static Map<String, Object> configurationMap;
    public static Map<String, String> headersMap;
    public static String BASE_URL;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        configurationMap = JsonUtil.getJsonDataAsMap(env);
        BASE_URL = configurationMap.get("baseUrl").toString();
//        headersMap.put("Authorization", "Bearer "+configurationMap.get("token"));
    }
}
