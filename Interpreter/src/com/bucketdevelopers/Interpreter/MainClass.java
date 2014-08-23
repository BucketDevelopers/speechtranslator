package com.bucketdevelopers.Interpreter;


public class MainClass {

	public static void main(String args[]) {

		TalkingClass.talkG("Hai.Whats up ?", "en-in");
		try{
			TransClass.translate("Good morning","ENGLISH","FRENCH");
		}
			catch(Exception e)
			{
				System.out.print("Caught");
			}
	}

}
