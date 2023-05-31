package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider = "data")
	public void friends(String name,String place,int age) {
		System.out.println("Name = "+name);
		System.out.println("Place = "+place);
		System.out.println("Age = "+age);
	}
@DataProvider
public  Object[][] data() {
	Object[][] arr = new Object[3][3];
	arr[0][0]="Gowtham";
	arr[0][1]="Maddur";
	arr[0][2]=24;
	
	arr[1][0]="Kanthraj";
	arr[1][1]="Malavalli";
	arr[1][2]=24;
	
	arr[2][0]="Karthi";
	arr[2][1]="Mangalur";
	arr[2][2]=24;
	return arr;
}

}
