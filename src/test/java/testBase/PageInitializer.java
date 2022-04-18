package testBase;

import pages.SandBoxElements;

public class PageInitializer extends BaseClass {

	protected static SandBoxElements sandBoxElements;
	
	public static void initializePageObjects() {
		
		sandBoxElements	= new SandBoxElements();	
			
	}
}
