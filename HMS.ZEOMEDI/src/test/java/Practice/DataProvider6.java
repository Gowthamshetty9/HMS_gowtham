package Practice;

import org.testng.annotations.Test;

public class DataProvider6 {
	@Test(dataProviderClass = DataProvider3.class,dataProvider = "data")
	public void Hombale(String Production, String Film ,String director, int year, String hero) {
		System.out.println("ProductionHouse = "+Production);
	 	System.out.println("Film = "+Film);
		System.out.println("Director = "+director);
		System.out.println("YearofRelese = "+year);
		System.out.println("Hero = "+hero);
	}
}
