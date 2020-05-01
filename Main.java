/**
 * This class kicks off the game NibbleNabble, and continues playing until the user quits.
 * 
 * @author Jennifer Olenic
 * @version 1.0
 * @since 1.8
 *
 */

import java.util.Random; //import Random
import java.util.Scanner; //import Scanner

public class Main {

    //declares a new instance of NibbleNabble and loops game until user quits
	public static void main(String[] args) {
	    boolean quit = false;
	    NibbleNabble game = new NibbleNabble();
	    while (quit == false) {
	        game.playGame();
	        quit = game.quit();
	        }
	    System.out.println("Goodbye!");
	    } //end main
	
} //end of class Main
