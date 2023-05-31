package Practice;

import org.testng.annotations.Test;

public class DataProviderClass {
	@Test(dataProviderClass = DataProvider.class,dataProvider = "data")
public void classdata(String src,String dest) {
	System.out.println(src+" to "+dest);
}
}
