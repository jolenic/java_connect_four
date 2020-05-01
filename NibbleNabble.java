
import java.util.Scanner;
import java.util.Random;

/**
 * This class implements a simple version of Connect Four, called NibbleNabble.
 * @author Jennifer Olenic
 * @version 1.0
 * @since 1.8
 */
public class NibbleNabble {

    private Player currentPlayer;
	private Player computer;
	private Player user;
	private Board board;
	private Scanner input;
	
	// Prints welcome and initializes board and players
	public NibbleNabble() {
	    this.input = new Scanner(System.in);
        System.out.println("Welcome to Connect Four!");
        System.out.println("Please enter your name:");
        String playerName = input.nextLine();
        this.user = new Player(playerName);
        this.computer= new Player();
        this.currentPlayer = user;
        System.out.println("Hi, " + user.getName() + "!");
        this.board = new Board();
	} //end of method NibbleNabble
	
    // currentPlayer makes a move.  If nobody has won yet, currentPlayer switches and another turn goes.
	public boolean playGame() {
	        while (true) {
	            board.display();
	            int column = 0;
	            
	            System.out.print(currentPlayer.getName() + " > ");
	            
	            while (column == 0) {
	                
	                if (currentPlayer == computer) {
	                    column = new Random().nextInt(7) + 1;
	                    System.out.println(column);
	                } else {
	                    String move = input.next();
	                    if (move.toUpperCase().charAt(0) == 'Q') {
	                        return false;
	                    }
	                    column = Integer.parseInt(move);
	                }
	                
	                if (!board.makeMove(column-1, this.currentPlayer.getToken())) {
	                    column = 0;
	                }
	                
	            }
	            //Checks to see if anyone has won.
	            if (board.checkVictory('O')) {
	                System.out.println("Oh no! The computer won!"); 
	                board.display();
	                break;
	            } else if (board.checkVictory('X')) {
	                System.out.println("You are victorious!!!");
	                board.display();
	                break;
	            } else if (board.isFull()) {
	                System.out.println("I guess it's a tie!");
	                board.display();
	                break;
	            }
	            currentPlayer = togglePlayer();

	        }
	        return true;
	    } //end playGane

	// Resets board and asks user to quit or keep playing.
	public boolean quit() {
		this.board = new Board();
		String response;
	    System.out.println("Enter Q to quit, or any key to keep playing: ");
		response = this.input.next();
		if (response.toUpperCase().charAt(0) == 'Q') {
		    System.out.println("Thanks for playing!");
            return true;
		} else {
		    return false;
		}
	} //end of method quit

    //Switches active player between computer and user.
	private Player togglePlayer() {
		if (this.currentPlayer == user) {
		    this.currentPlayer = computer;
		} else{
		    this.currentPlayer = user;
		}
		return currentPlayer;
	} //end togglePlayer
	
} //end of class NibbleNabble
