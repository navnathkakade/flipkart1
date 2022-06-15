package ListenersClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClasses1  implements ITestListener  {
	
public void onTestStart(ITestResult result) {
	   System.out.println(result.getName() + "Test Pass");
	   
	  }
 public void onTestSuccess(ITestResult result) {
	   System.out.println(result.getName() + "Test Success");
	  }
 public  void onTestFailure(ITestResult result) {
	 System.out.println(result.getName() + "Test Failure");
	  }
 public void onTestSkipped(ITestResult result) {
	 System.out.println(result.getName() + "Test Skipped");
	  }

	
	
}
