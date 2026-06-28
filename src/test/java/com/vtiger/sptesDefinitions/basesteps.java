package com.vtiger.sptesDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.AccountPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class basesteps {

    public static WebDriver driver;
    public static Map<String,Map<String,String>> dt;
    public static Properties prop;
    public static String TCName;
    public static LoginPage lp;
    public static HomePage hp;
    public static LeadPage ldp;
    public static AccountPage acp;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    public static void readconfig() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Configuration/config.properties");
        prop.load(fis);
    }


    public static void createExtentReport()
    {
        //report_13042025104034.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport_"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

    public static void readExcelData(String sheetName) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
        String strQuery="Select * from "+sheetName;
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> lst  = recordset.getFieldNames();

        dt = new HashMap<>();

        while(recordset.next()){
            Map<String,String> map = new HashMap<>();
            for(int i=0;i<lst.size();i++)
            {
                String colmname = lst.get(i);
                String value = recordset.getField(colmname);
                map.put(colmname,value);
            }
            dt.put(recordset.getField("TCName"),map);

        }
        System.out.println(dt);

        recordset.close();
        connection.close();
    }

}
