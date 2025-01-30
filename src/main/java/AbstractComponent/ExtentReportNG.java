package AbstractComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    public static ExtentReports getReportObjects() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("D:\\selenium\\Pom\\reports\\report.html");
        reporter.config().setReportName("TestComponent");
        reporter.config().setDocumentTitle("Test Results");
    ExtentReports extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Aely");
    return extent;
    }

}
