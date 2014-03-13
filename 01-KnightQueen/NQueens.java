import java.util.*;

public class NQueens {

	private int[] board;
	private boolean[] hmmm;
	private int numsolutions;
	
	public NQueens(int n) {
		
		board = new int[n];
		hmmm = new boolean[n];
		numsolutions = 0;
		
		for (int i=0; i<n; i++) {
			board[i] = -1;
			hmmm[i] = false;
		}
	}

	public void solve() {
		PlaceQueens(0);
	}

	public void PlaceQueens(int location) { 
    	int i;
    	if (location == board.length) {
        	printSolution();
        	numsolutions++;
    	}
    
    	for (i=0; i<board.length; i++) {
        	if (hmmm[i] == false) {
            	if (!conflict(location, i)) {
                	board[location] = i;
                	hmmm[i] = true;
                	PlaceQueens(location+1);
                	hmmm[i] = false;
            	}                         
                                 
        	}    
    	}
     
	} 

	private boolean conflict(int location, int row) {
    	int i;
    	for (i=0; i<location; i++)
        	if (Math.abs(location - i) == Math.abs(board[i] - row))
            	return true;
    	return false;    
	}
	public void printSolution() {
     
    	int i,j;
          
     	System.out.println("Here is a solution:\n");
     	for (i=0; i<board.length; i++) {
         	for (j=0; j<board.length; j++) {
             	if (board[j] == i)     
                	System.out.print("Q ");
             	else
                	System.out.print("_ ");
         	}
         	System.out.println("\n");
     	}
	}
	
	public void printNumSolutions() {
		System.out.println("There were "+numsolutions+" solutions.");
	}
	
	public static void main(String[] args) {
    	NQueens Q = new NQueens(5); //change 5 to whatever number you desire
    	Q.solve();
    	Q.printNumSolutions();
    	
    	System.out.println("Please change board size by changing the parameter for NQueens above.");
	}
	
	
}