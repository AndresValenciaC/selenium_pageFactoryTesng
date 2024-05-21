package com.ect.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataClass {
    Properties properties = new Properties();

    public ConfigDataClass() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}
