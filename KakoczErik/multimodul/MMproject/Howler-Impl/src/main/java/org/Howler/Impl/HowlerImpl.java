package org.Howler.Impl;

import org.Howler.Howler;

/**
 * Hello world!
 *
 */
public class HowlerImpl implements Howler
{
	String howl;

	public void ListenToHowl(String Howl) {
		howl=Howl;
		
	}

	public String AnswerHowl() {
		return howl;
	}
    
}
