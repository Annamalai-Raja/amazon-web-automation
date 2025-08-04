package com.flipkart.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public interface Configurations {

    String APP_URL = getProperty("url");


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
