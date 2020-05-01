/**
 * This class simulates a NibbleNabble game board.
 * @author Jennifer Olenic
 * @version 1.0
 * @since 1.8
 *
 */
public class Board {
	
	// Number of rows on the board
	private final static int NUM_ROWS = 6;
	
	// Number of columns on the board
	private final static int NUM_COLS = 7;
	
	// Array of Column objects, which contain token values
	private Column[] board = new Column[NUM_COLS];
	
	//Loops through board array to instantiate and initialize each element as a new Column.
	public Board() {
		for (int k = 0; k<board.length; k++) {
		    board[k] = new Column();
		}
    }
	
	// Creates a String containing the characters from a specified row on the board.
	public String getRow(int num) {
	    String row = "";
	    for (Column col : board) {
	        row += col.getToken(num);
	    }
	    return row;
    } //end getRow
	
	// validates the user input, attempts to put the token in the column
	public boolean makeMove(int column, char token) {
		if ((column < 0) || (column > 6)) {
		    System.out.println("Please enter a number between 1-7: ");
		    return false;
		}
	    return this.board[column].putToken(token);
	} //end makeMove
	
    //checks for victory conditions for a given token.
	public boolean checkVictory(char token) {
		
		// Checks columns
        for (int k = 0; k<board.length; k++) {
            if (board[k].verticalVictory(token)) {
                return true;
            }
        }
		// Checks rows 
		for (int row = 0; row < NUM_ROWS; row++) {
		    int count = 0;
		    String check = getRow(row); 
		    for (int k = 0; k<check.length(); k++) {
		        if (check.charAt(k) == token) {
		            count++;
		        } else {
		            count = 0;
		        }
		        if (count >=4) {
		            return true;
		        }
		    }
		}		
		
    // If no win conditions are met, returns false
        return false;
    } //end checkVictory

    //checks to see if the board is full
    public boolean isFull() {
        for (int k = 0; k <= 6; k++) {
            if (this.board[k].getHeight() < 6) {
                return false;
            }
        } 
        return true;
    } //end isFull

    //displays the grid of columns and rows
    public void display() {
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (int k=5; k>=0; k--) {
            System.out.print("|");
            for (Column col : board) {
                System.out.print(col.getToken(k) + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
        System.out.println(" 1 2 3 4 5 6 7");
    } //end display
	
} //end of class Board
