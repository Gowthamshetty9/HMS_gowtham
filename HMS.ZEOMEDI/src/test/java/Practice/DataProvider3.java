package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
	@DataProvider
public Object[][] data() {
	Object[][] arr = new Object[4][5];
	arr[0][0]="Hombale";
	arr[0][1]="KGF1";
	arr[0][2]="Prashanth Neel";
	arr[0][3]=2018;
	arr[0][4]="Yesh";
	
	arr[1][0]="Hombale";
	arr[1][1]="KGF2";
	arr[1][2]="Prashanth Neel";
	arr[1][3]=2022;
	arr[1][4]="Yesh";
	
	arr[2][0]="Hombale";
	arr[2][1]="Kanthara";
	arr[2][2]="Reshab Shetty";
	arr[2][3]=2022;
	arr[2][4]="Reshab Shetty";
	
	arr[3][0]="Hombale";
	arr[3][1]="Yuvarathnaa";
	arr[3][2]="Santhosh Anandram";
	arr[3][3]=2021;
	arr[3][4]="Punith Rajkumar";
	return arr;
}
	@Test(dataProvider = "data")
	public void Hombale(String Production, String Film ,String director, int year, String hero) {
		System.out.println("ProductionHouse = "+Production);
		System.out.println("Film = "+Film);
		System.out.println("Director = "+director);
		System.out.println("YearofRelese = "+year);
		System.out.println("Hero = "+hero);
	}
}
