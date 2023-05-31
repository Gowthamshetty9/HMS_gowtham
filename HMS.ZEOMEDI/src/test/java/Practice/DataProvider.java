package Practice;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider = "data")
public void gatdata(String src,String dest) {
	System.out.println(src+" to "+dest);
}
@org.testng.annotations.DataProvider
public Object[][] data() {
	Object[][] arr = new Object[2][2];
	arr[0][0]="bangalore";
	arr[0][1]="mysore";
	arr[1][0]="qspiders";
	arr[1][1]="testyentra";
	return arr;
}
}
