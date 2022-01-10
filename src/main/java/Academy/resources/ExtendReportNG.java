package Academy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {

     static ExtentReports extent;

    public static ExtentReports getReportObject()
    {

        String path =System.getProperty("/Users/muzaffarahmed/Desktop/Github/Selenium-project/Practice-tutorial/AcademyTest")
                +"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul Shetty");
        return extent;

    }
}
