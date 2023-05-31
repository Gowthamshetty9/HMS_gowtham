package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HMS.testyantra.genricutility.excelutility;

public class DataProviderExcelgenric {
	@DataProvider
public  Object[][] retrive() throws Throwable {
	excelutility excelutils=new excelutility();
	Object[][] obj = excelutils.data("dataprovider");
	return obj;
}
	@Test(dataProvider = "retrive" )
public void travel(String src,String dest, String price) {
	System.out.println(src+" to "+dest+" price "+price);
}
}
 