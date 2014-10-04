//"AIzaSyBparHCDwfzeaEmbbkeT0-67lSwLZdEPKA"
package com.bucketdevelopers.Interpreter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import javaFlacEncoder.FLACFileWriter;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;

public class RecognitionClass {
	static String returnString = new String();
	static String BINGKEY;

	public static void RecognitionFunction(String BING_API_KEY,
			String GOOGLE_API_KEY) {
		
		BINGKEY = BING_API_KEY;
		
		GSpeechDuplex d = new GSpeechDuplex(GOOGLE_API_KEY);// Instantiate the
															// API
		d.addResponseListener(new GSpeechResponseListener() {// Adds the
																// listener
			public void onResponse(GoogleResponse gr) {
				// RecognitionClass rec = new RecognitionClass();
				returnString = gr.getResponse();
				System.out.println("Google thinks you said: " + returnString);
				try {
					TransClass tr = new TransClass(BINGKEY);
					tr.translate(returnString, "ENGLISH", "FRENCH");
					System.out.println("TRANSLERTE :" + tr.texttanslate);
					TalkingClass.talkG(tr.texttanslate, tr.l2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("with " +
				// ((gr.getConfidence()!=null)?(Double.parseDouble(gr.getConfidence())*100):null)
				// + "% confidence.");
				//
				// System.out.println("Google also thinks that you might have said:"
				// + gr.getOtherPossibleResponses());
			}
		});
		Microphone mic = new Microphone(FLACFileWriter.FLAC);// Instantiate
																// microphone
																// and have
		// it record FLAC file.
		File file = new File("CRAudioTest.flac");// The File to record the
													// buffer to.
		// You can also create your own buffer using the getTargetDataLine()
		// method.
		try {
			mic.captureAudioToFile(file);// Begins recording
			Thread.sleep(2000);// Records for 10 seconds
			mic.close();// Stops recording

			String name = file.getAbsolutePath();
			Path path = Paths.get(name);
			byte[] data = Files.readAllBytes(path); // Saves data into memory.
			// Sends 10 second voice recording to Google
			d.recognize(data, (int) mic.getAudioFormat().getSampleRate());
			mic.getAudioFile().delete();// Deletes Buffer file
			// REPEAT
		} catch (Exception ex) {
			ex.printStackTrace();// Prints an error if something goes wrong.
		}

	}

}
