package com.qapitol.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWritePropertyFile {
    static String filepath="C:\\Users\\Qapitol QA\\IdeaProjects\\OrangeHRMProject\\src\\main\\resources\\data.properties";
    static Properties properties;
    public static void readProperty() throws IOException {
        properties=new Properties();
        File file=new File(filepath);
        FileInputStream fis=new FileInputStream(file);
        properties.load(fis);
    }
    public static String getObject(String data) throws IOException {
        readProperty();
        return properties.getProperty(data);
    }
}
