package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {
@BeforeClass
public void Beforeclass() {
	System.out.println("  Before class  ");
}
@BeforeMethod
public void beforemethod() {
	System.out.println("   beforemethod   ");
}
@BeforeSuite
public void beforesuite() {
	System.out.println("   before suite   ");
}
@AfterClass
public void afterclass() {
	System.out.println("  afterclass  ");
}
@AfterSuite
public void aftersuite() {
	System.out.println("  aftersuite  ");
}
@Test
public void test() {
	System.out.println("  test  ");
}
@AfterMethod
public void aftermethod() {
	System.out.println("  aftermethod  ");
}
}
