package com.bucketdevelopers.Interpreter;

import java.io.InputStream;

import com.bucketdevelopers.libs.Mp3Player;
import com.darkprograms.speech.synthesiser.Synthesiser;
/*
 * USAGE : TalkingClass.talk("String to talk","language ISO code");
 * EXAMPLE : TalkingCLass.talk("Hello","en-in");
 * Use null for language for auto language selection.
 */



public class TalkingClass {
	
	//TalkG for Talk using Google Synthesizer
	public static void talkG(String text , String language) {
		//String language = "auto";//Uses language autodetection
		//String language = "en-in";// English (IN) language code //If you want to
									// specify a language use the ISO code for
									// your country. Ex: en-us
		System.out.println("TALK: ");
		
		if(language==null){
			language = "auto";
		}
		language="fr-FR";
		
		Synthesiser synth = new Synthesiser(language);
		try {
			InputStream is = synth.getMP3Data(text);
			// Use any Java MP3 Implementation to play back the AudioFile
			// from the InputStream.
			//Here we use Mp3zoom to do it using a custom class Mp3Player
			
			Mp3Player plyr = new Mp3Player();
			plyr.playfromInputStream(is);
						
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			return;
		}
	}

}
