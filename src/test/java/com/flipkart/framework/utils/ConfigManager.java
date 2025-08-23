package com.flipkart.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public interface ConfigManager {

    String APP_URL = getProperty("url");

    String BS_USERNAME = getProperty("browserstack.username");

    String BS_Password = getProperty("browserstack.accesskey");

    String BS_HUB_URL = getProperty("browserstack.hub.url");

    boolean IS_CLOUD = Boolean.parseBoolean(getProperty("is.cloud"));

    String EXECUTION_MODE = getProperty("execution.mode");

    String USER_DIR = System.getProperty("user.dir");

      static String getProperty(String key) {
          Properties properties = new Properties();
          try {
              FileInputStream  input = new FileInputStream("resources/config.properties");
              properties.load(input);
          } catch (IOException e) {
              System.out.println("Given Key not found - " + e);
          }

          return properties.getProperty(key);
      }

}
