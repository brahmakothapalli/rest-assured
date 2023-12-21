package base;

import utilities.JsonUtil;

import java.util.Map;

public class BaseTest {

    public static Map<String, Object> configurationMap;
    public static Map<String, String> headersMap;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        configurationMap = JsonUtil.getJsonDataAsMap(env+".json");

        headersMap.put("Authorization", "Bearer "+configurationMap.get("token"));
    }
}
