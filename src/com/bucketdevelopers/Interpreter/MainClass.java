package com.bucketdevelopers.Interpreter;

public class MainClass {

	private static String BING_API_KEY = "PUT YOUR BING API KEY HERE";
	private static String GOOGLE_API_KEY = "PUT YOUR GOOGLE API KEY HERE";
	
	
	public static void main(String args[]) throws Exception {

		RecognitionClass.RecognitionFunction(BING_API_KEY, GOOGLE_API_KEY);

	}

}
