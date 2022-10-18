package org.wightwalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LaunchManager {
  private static Properties properties;

  static {
    properties = new Properties();
      try {
        properties.load(new FileInputStream("resources/source.properties"));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public static String getProperty(String property) {
    return properties.getProperty(property);
  }
}
