package com.bucketdevelopers.libs;

/*
 * 
 * REQUIRED LIBS in libs folder
 * 
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;


public class Mp3Player {
    private String filename;
    private Player player; 

    // constructor that takes the name of an MP3 file
    public Mp3Player(String filename) {
        this.filename = filename;
    }
    public Mp3Player(){
    	this.filename=null;
    	
    }

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }

    public void playfromInputStream(InputStream is){
   	 
    	try {
            BufferedInputStream bis = new BufferedInputStream(is);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing Stream");
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
   	 
    }

    // test client
//    public static void main(String[] args) {
//        String filename = args[0];
//        Mp3Player mp3 = new Mp3Player(filename);
//        mp3.play();
//
//        // when the computation is done, stop playing it
//        mp3.close();
//
//    }

}
