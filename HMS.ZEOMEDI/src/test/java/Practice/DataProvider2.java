package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@DataProvider
public  Object[][] data() {
	Object[][] arr = new Object[4][4];
	arr[0][0]="India";
	arr[0][1]="Delhi";
	arr[0][2]="Karnataka";
	arr[0][3]="Bangalore";
	
	arr[1][0]="India";
	arr[1][1]="Delhi";
	arr[1][2]="TamilNadu";
	arr[1][3]="Chennai";
	
	arr[2][0]="India";
	arr[2][1]="Delhi";
	arr[2][2]="Kerala";
	arr[2][3]="Kochi";
	
	arr[3][0]="India";
	arr[3][1]="Delhi";
	arr[3][2]="Goa";
	arr[3][3]="Panaji";
	return arr;
	}
	@Test(dataProvider = "data")
	public void capitals(String country,String Ccapital,String state,String Scapital) {
		System.out.println("Country = "+country);
		System.out.println("CountryCapital = "+Ccapital);
		System.out.println("State = "+state);
		System.out.println("StateCapital = "+Scapital);
	}
}
