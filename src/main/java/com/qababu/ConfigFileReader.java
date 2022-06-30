package com.qababu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties prop = new Properties();
    private static ConfigFileReader configFileReader;
    private static InputStream inputStream;

    /**
     * Private constructor is to restrict other classes from creating the objects
     * loading the property file
     */
    private ConfigFileReader() throws IOException {
        try{
            String fileName = "config.properties";
            inputStream = ConfigFileReader.class.getClassLoader().getResourceAsStream(fileName);
            if(inputStream != null){
                prop.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert inputStream != null;
            inputStream.close();
        }
    }

    public static ConfigFileReader getInstance(){
        if(configFileReader == null){
            synchronized (ConfigFileReader.class){
                try{
                    configFileReader = new ConfigFileReader();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Failed create the object of ConfigFileReader class"+e.getMessage());
                }
            }
        }
        return configFileReader;
    }

    public String getProperty(String key){

        return prop.getProperty(key);
    }
}
