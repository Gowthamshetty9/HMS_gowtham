package Practice;

import org.testng.annotations.Test;

public class DataProvider4 {
	@Test(dataProviderClass  = DataProvider1.class,dataProvider = "data")
	public void friends(String name,String place,int age) {
		System.out.println("Name = "+name);
		System.out.println("Place = "+place);
		System.out.println("Age = "+age);
	}
}
