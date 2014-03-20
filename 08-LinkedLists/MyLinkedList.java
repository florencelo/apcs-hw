public class MyLinkedList {

    private Node head;
    private int listCount;

    public MyLinkedList() {
	head = null;
	listCount = 0;
    }
    
    public void add(String d) {
	Node tmp = new Node(d);
	tmp.setNext(head);
	head=tmp;
	listCount++;
    }
    
    /*public String toString() {
      Node tmp = head;
      String s= "";
      while(tmp != null) {
      tmp = tmp.getNext();
      s += " " + tmp;
      }
      return s;
      }*/
    
    public void add(int index, String s){
    	Node temp = new Node(s);
	Node current = head;
	for(int i = 1; i < index && current.getNext() != null; i++)
	    {
		current = current.getNext();
	    }
	temp.setNext(current.getNext());
	current.setNext(temp);
	listCount++;

    }
    public String get(int index)
    {
	if(index <= 0)
	    return null;
		
	Node current = head.getNext();
	for(int i = 1; i < index; i++)
	    {
		if(current.getNext() == null)
		    return null;
			
		current = current.getNext();
	    }
	return current.getData();
    }
	
    public boolean remove(int index)
    {
	if(index < 1 || index > size())
	    return false;
		
	Node current = head;
	for(int i = 1; i < index; i++)
	    {
		if(current.getNext() == null)
		    return false;
			
		current = current.getNext();
	    }
	current.setNext(current.getNext().getNext());
	listCount--; 
	return true;
    }
	
    public int size()
    {
	return listCount;
    }

    /*
Method 1: use a loop a la toString to calculate the length and return it O(n)
Method 2: make a length instance variable add 1 to length in add routines subtract 1 from length in remove routines just returns length amortized O(k)

amortized - calc use of money over time
     */
	
    public String toString()
    {
	Node current = head.getNext();
	String output = "";
	while(current != null)
	    {
		output += "[" + current.getData().toString() + "]";
		current = current.getNext();
	    }
	return output;
    }

    public static void main(String[] args){
    	MyLinkedList L = new MyLinkedList();

    	L.add("Sully");
    	System.out.println(L);
    	L.add("mike");
    	System.out.println(L);
    	L.add("randall");
    	System.out.println(L);
    	L.add("boo");
    	System.out.println(L);

    }


}
