
public class BSTNode {
    private int data;
    private BSTNode left,right;

    public BSTNode(int d) {
    	data = d;
    	left = null;
    	right = null;
        }

        public void setData(int d) {
    	data = d;
        }
        public int getData() {
    	return data;
        }
        public void setNextL(BSTNode n){
    		left = n;
        }
        public void setNextR(BSTNode n){
        	right = n;
        }
        public BSTNode getNextL() {
        	return left;
        }
        public BSTNode getNextR() {
        	return right;
        }
        public String toString() {
    	return " " + data;
        }
}


