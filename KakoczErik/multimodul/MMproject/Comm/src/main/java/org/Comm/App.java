package org.Comm;

import org.Howler.Impl.HowlerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	HowlerImpl hi=new HowlerImpl();
    	String input="Whassup?";
    	hi.ListenToHowl(input);
    	System.out.println(hi.AnswerHowl());
    }
}
