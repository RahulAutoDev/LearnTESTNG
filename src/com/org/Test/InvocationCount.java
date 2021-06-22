package com.org.Test;

import org.testng.annotations.Test;

public class InvocationCount {
	
	@Test(invocationCount=5)
	public void testInvocation()
	{
		System.out.println("c");
	}
	

}
