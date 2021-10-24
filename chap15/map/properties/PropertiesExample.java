package chap15.map.properties;

import java.io.*;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        String path = PropertiesExample.class.getResource("database.properties").getPath();
        path = URLDecoder.decode(path, "utf-8");
        properties.load(new FileReader(path));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String username = properties.getProperty("username");

        System.out.println("driver: " + driver);
        System.out.println("url: " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
