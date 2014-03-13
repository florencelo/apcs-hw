public class KTour {

    private int[][] board;
    private boolean solved;
    private boolean closed;

    public KTour() {
    	board = new int [5][5];
    }

    public String toString(){
        String str = "";
        for (int a=0; a<5; a++) {
            for (int b=0; b<5; b++) {
                str += expandString(board[a][b], 3);
            }
            str += "\n";
        }
        return str;
    }

    public String expandString(int a, int b) {
        String str = "" + a;
        int strL = str.length();
        for (int i=0; i<b-strL+1; i++) {
            str = " " + str;
        }
        return str;
    }

    public void solve() {
        solve(0, 3, 1);
        if (!solved) {
                System.out.println("There is no solution for a " + 5 + "x" + 5 + " board!");
        }
    }

    public void solve(int x, int y, int n) {
		if (x >= 0 && y >= 0 && x < 5 && y < 5) {
            if (board[x][y] == 0) {
                board[x][y] = n;
                if (!solved) solve(x-1, y-2, n+1);
                if (!solved) solve(x+2, y-1, n+1);
                if (!solved) solve(x+2, y+1, n+1);
                if (!solved) solve(x-2, y+1, n+1);
                if (!solved) solve(x+1, y+2, n+1);
                if (!solved) solve(x+1, y-2, n+1);
                if (!solved) solve(x-2, y-1, n+1);
                if (!solved) solve(x-1, y+2, n+1);
                if (!solved) board[x][y] = 0;
            }
            else if (n == 26) {
                if (!closed) {
                    solved = true;
                }
                else if (board[x][y] == 1) {
                    solved = true;
                }
            }
        }
    }

    public static void main(String[] args) {       
        KTour tour = new KTour();
        tour.solve();
        System.out.print(tour);
        
        System.out.println(" \n Please type in your starting point in the solve() function in my code. Thank You. ");
    }

}
