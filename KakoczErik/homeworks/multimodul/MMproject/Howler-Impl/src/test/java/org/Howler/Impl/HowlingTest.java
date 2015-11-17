package org.Howler.Impl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class HowlingTest{

	@Test
	public void HowlerImplTest(){
		HowlerImpl howler=new HowlerImpl();
		howler.ListenToHowl("Hello!");
		String control="Hello!";
		String result=howler.AnswerHowl();
		
		assertEquals(control,result);
		
	}
	
}
