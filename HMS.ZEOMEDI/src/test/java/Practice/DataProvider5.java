package Practice;

import org.testng.annotations.Test;

public class DataProvider5 {
	@Test(dataProviderClass = DataProvider2.class,dataProvider = "data")
	public void capitals(String country,String Ccapital,String state,String Scapital) {
		System.out.println("Country = "+country);
		System.out.println("CountryCapital = "+Ccapital);
		System.out.println("State = "+state);
		System.out.println("StateCapital = "+Scapital);
}
}