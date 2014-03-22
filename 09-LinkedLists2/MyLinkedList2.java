public class MyLinkedList2 {

    private Node head;
    private int listCount;

    public MyLinkedList2() {
    	
    	head = new Node("");
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

empty list
head -> dummy(null)
head -> dummy -> 0 -> 1 -> 2...

i = 0;
tmp = head.getNext();
T2 = head;

while (i<n){
T2 = tmp;
tmp = tmp.getNext();
i = i+1;
}

// result: tmp is at event point and t2 is one before
t2.setNext(tmp.getNext()); or t2.setNext(t2.getNext().getNext());
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

    /*public int size(){
		int count = 0;
		Node curr = head;
		while(curr != null){//traverse through list
			count++;
			curr = curr.next;
		}
		return count;
	}*/    
    
    public int find(String s) {

		if (s == null) // look for a null element in the list
		{
			int index = 0;
			for (Node p = head; p != null; p = p.getNext()) {
				if (p.getNext() == null) {
					return index;
				}
				index++;
			}
		} else 
		{
			int index = 0;
			for (Node p = head; p != null; p = p.getNext()) {
				if (s.equals(p.getNext())) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}

    
   public String set( int i, String s )
    {
    Node p = new Node(s);
    String oldVal = p.getData();
    p.setData(s); 
   return oldVal;
    }
    
    
    public static void main(String[] args){
    	MyLinkedList2 L = new MyLinkedList2();

    	L.add("Sully");
    	System.out.println(L);
    	L.add("Mike");
    	System.out.println(L);
    	L.add("Randall");
    	System.out.println(L);
    	L.add("Boo");
    	System.out.println(L);
    	L.add("Boo");
    	System.out.println(L);
    	L.add(2,"Boo");
    	System.out.println(L);
    	L.remove(2);
    	System.out.println(L);
    	L.get(3);
    	System.out.println(L);
    	
    }


}
