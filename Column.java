/**
 * 
 * This class is a single Column on the board, containing vertically stacked X and O tokens.
 * 
 * @author Jennifer Olenic
 * @version 1.0
 * @since 1.8
 *
 */
import java.util.Arrays;

public class Column {

    //declares private variables
	private static final int MAX_HEIGHT = 6;
	private int height = 0;
	private char[] column;
	
    // default constructor to create columns of MAX_HEIGHT full of empty spaces
	public Column() {
		this.column = new char[MAX_HEIGHT];
		Arrays.fill(this.column, ' ');
	}
	
	//returns the character in a given index of the column
	public char getToken(int row) {
		return column[row];
	} //end getToken
	
	//places the token on top of the stack, if there is space.
	public boolean putToken(char token) {
	    if (height < MAX_HEIGHT) {
	        column[height] = token;
	        height++;
	        return true;
	    } else {
	        System.out.println("This column is already full!");
	        System.out.println("Choose a different column:");
	        return false;
	    }
	} //end putToken
	    
    //checks to see if a column has 4 in a row of a specified token
	public boolean verticalVictory(char token) {
        int count = 0;
	    for (int k = 0; k<this.height; k++) {
		    if (column[k] == token) {
		        count++;
		        if (count == 4) {
		            return true;
		        }
		    } else {
		        count = 0;
		    }
		}
		return false;
	} //end verticalVictory
	
    //returns current height of column
	public int getHeight() {
		return height;
	} //end getHeight
	
} //end of class Column
