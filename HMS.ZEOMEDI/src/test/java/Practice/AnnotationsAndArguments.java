package Practice;

import org.testng.annotations.Test;

public class AnnotationsAndArguments {
	@Test(dependsOnMethods = "delete")
public void create() {
	System.out.println("created  ");
}
	
	@Test()
public void update() {
	System.out.println("updated  ");
}
	
	@Test(enabled = false)
public void delete() {
	System.out.println("deleted  ");
}
}
