package com.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ReadPropFile {
    private static Properties prop;
    private final static String propertFilePath = "C:\\Users\\Qapitol QA\\IdeaProjects\\bck\\DemoAutomation\\src\\main\\resources\\config\\data.properties";

    private static void loadData() throws IOException, FileNotFoundException {
        prop = new Properties();
        //System.getProperty("user.dir")+"propertFilePath";
      //  File f=new File(System.setpropert(user.dir)+"propertFilePath");
        File f = new File(propertFilePath);

        FileReader obj = new FileReader(f);
        prop.load(obj);
    }

    public static String getObject(String data) throws IOException {
        loadData();
        return prop.getProperty(data);
    }
}
