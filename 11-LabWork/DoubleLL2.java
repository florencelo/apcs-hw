public class DoubleLL2<E>{

    private class Node<E>{
	E data;
	Node<E> next, prev;
	public Node(E d){
	    this.data = d;
	}
	public String toString(){
	    return ""+data;
	}

	public void setData(E d){ data = d;}
	public E getData(){ return data;}

	public void setNext(Node<E> n){next = n;}
	public Node<E> getNext(){ return next;}

	public void setPrev(Node<E> p){ prev = p;}
	public Node<E> getPrev(){ return prev;}
    }

    private Node<E> current;

    public void insert(E d){
	Node<E> n = new Node<E>(d);
	if (current==null){
		current = n;
		current.prev = n;
		current.next = n;
	}
	else{
	    Node temp = current.getNext();
	    current.setNext(n);
	    n.setPrev(current);
	    n.setNext(temp);
	    temp.setPrev(n);
	}
	//n.next = current;
	//current.prev = n;
	current = n;
	size ++;
    }


    public E getCurrent(){ return current.getData();}

    public void foward(){
	if(current.getNext() != null)
	    current = current.getNext();
    }

    public void back(){
	if(current.getPrev() != null){
	    current = current.getPrev();
	}
    }

    public String toString(){ //change so it ends when it reaches the beginning. No more null.
    	Node<E> a = current;
	if(current == a)
	    return " " + current;
	while( current.getPrev() != a)
	    current = current.getPrev();

	Node<E> tmp = current;
	String s = "";
	while(tmp != a){
	    s = s+tmp.getData() + " ";
	    tmp = tmp.getNext();
	}
	return s;
    }
    
    private int size; 
    
    public void delete(int idx){        
    	Node<E> a = current;
    	Node<E> b = null;
        if (idx == 1) 
        {
            if (current == current.next)
            {
                b = current; 
            }
            a = a.getNext();
            a.setPrev(b);
            b.setNext(a);
            size--; 
            return ;
        }
        if (idx == size)
        {
            b = b.getPrev();
            b.setNext(a);
            a.setPrev(b);
            size-- ;
        }
        Node ptr = a.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == idx)
            {
                Node p = ptr.getPrev();
                Node n = ptr.getNext();
 
                p.setNext(n);
                n.setPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getNext();
        }        
    } 
    
    public int find(E a){
    	return 1;
    }

    public static void main(String[] args){
	DoubleLL2<String> L = new DoubleLL2<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	System.out.println(L.getCurrent());
       	L.foward();
	System.out.println(L);
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
	L.delete(2);
    }
}