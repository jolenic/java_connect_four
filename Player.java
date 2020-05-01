/**
 * This class implements a simple Player of the game NibbleNabble.
 * @author Jennifer Olenic
 * @version 1.0
 * @since 1.8
 *
 */
public class Player {

	//declares  private properties name and token
    private String name;
    private char token;
	

	//No-args constructor initializes the name to Computer and token to the letter O.
    public Player () {
        this.name = "Computer";
        this.token = 'O';
    }

    //Initial constructor initializes the user's name to the specified parameter and token to the letter X.
    public Player (String playerName) {
        this.name = playerName;
        this.token = 'X';
    }
    
	//Getter method that returns the Player's name.
    public String getName() {
        return name;
    } //end getName

	//Returns the Player's token (X or O).
	public char getToken() {
	    return token;
	} //end getToken
	
} //end of class Player