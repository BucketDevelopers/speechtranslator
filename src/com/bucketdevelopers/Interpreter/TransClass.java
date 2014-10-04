package com.bucketdevelopers.Interpreter;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class TransClass {
	
	String texttanslate;
	String l2;
	String bingAPI_KEY;
	public TransClass(String KEY) {
			bingAPI_KEY=KEY;
		
	}
	public void translate(String text,String lang1,String lang2) throws Exception
	{
		//Replace client_id and client_secret with your own.  
	    Translate.setClientId("speechtrans1");
	    Translate.setClientSecret(bingAPI_KEY);
	 
	    // Translate text from lang1 to lang2
	    Language l1=Language.valueOf(lang2);
	    
	    String textTranslated = Translate.execute(text,l1);
	 	
	    System.out.println("Original langauge"+lang1+" phrase: " + text );
	    System.out.println("Translated to language"+lang2+" translated phrase: " + textTranslated);
	    l2 = lang2; 
	    texttanslate = textTranslated;
	}

}
