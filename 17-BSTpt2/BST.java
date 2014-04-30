
public class BST {
    private BSTNode root, pointer;

    public BST() {
        root = null;
        pointer = null;
    }
    
    public void insert(BSTNode a){
    	BSTNode c = root;
	pointer = root;
    	if(c != null && c.getData() < a.getData()){
    		pointer = c;
    		c = c.getNextL();
    	}
    	else if(c != null && c.getData() > a.getData()){
    		pointer = c;
    		c = c.getNextR();
    	}
    	else{
    		c = a;
    	}
    }
    
    public BSTNode search(int x){
    	BSTNode c = root;
    	while (c!= null && c.getData()!=x){
    		if(c.getData()<x){
    			c = c.getNextR();
    		}else c = c.getNextL();
    	}
    	return c;
    }
    
    public BSTNode search2(BSTNode c, int x){
    	if(c == null || c.getData() == x){
    		return c;
    	}
    	else{
    		if(c.getData() < x){
    			return search2(c.getNextL(),x);
    		}
    		else return search2(c.getNextR(),x);
    	}
    }
    
    public void delete(BSTNode a){
    	if(a == root){
    		BSTNode c = a.getNextL();
    		if(a.getNextL().getNextR() != null){
    			while(c.getNextR() != null){
        			c = c.getNextR();
    			}
    		}
    		a = c;
    	}
    	else if(a.getNextL() == null && a.getNextR() == null){
    		pointer.setNextL(null);
    		pointer.setNextR(null);
    	}
    	else if(a.getNextL() == null && a.getNextR() != null){
    		pointer.setNextR(a.getNextR());
    	}
    	else if(a.getNextL() != null && a.getNextR() == null){
    		pointer.setNextL(a.getNextL());
    	}
    	else{
    		BSTNode c = a.getNextL();
    		if(a.getNextL().getNextR() != null){
    			while(c.getNextR() != null){
        			c = c.getNextR();
    			}
    		}
    		a = c;
    	}
    }
    
    /* public String toString()
    {
	BSTNode L = pointer.getNextL();
	BSTNode R = pointer.getNextR();
	String output = "";
	while(L != null)
	    {
		output += "[" + L.getData() + "]";
		L = L.getNextL();
	    }
	while(R != null)
    {
	output += "[" + R.getData() + "]";
	R = R.getNextL();
    }
	return output;
	}*/

    public void traverse(BSTNode n){
	if (n == null){
	    System.out.println("Ain't nothing here yo.");
	}else{
	    traverse(n.getNextL()); //prints in order
	    System.out.println(n.getData());	    
	    traverse(n.getNextR());
	}
    }

    /*
in order Traversal: 
traverse(left)
process node
traverse(right)

preorder Traversal:
process node 
traverse(left)
traverse(right)

postorder Traversal:
traverse(left)
traverse(right)
process node

     */
    
    public static void main(String [] args){
    	BST a = new BST();
    	BSTNode b = new BSTNode(2);
    	BSTNode c = new BSTNode(3);
    	BSTNode d = new BSTNode(10);
    	BSTNode e = new BSTNode(7);
    	BSTNode f = new BSTNode(56);
    	BSTNode g = new BSTNode(43);
    	    	
    	a.insert(b);
    	a.insert(c);
    	a.insert(d);
    	a.insert(e);
    	a.insert(f);
    	a.insert(g);

    	a.search(2);
    	a.search2(b,2);

	a.traverse(e);

    }
}