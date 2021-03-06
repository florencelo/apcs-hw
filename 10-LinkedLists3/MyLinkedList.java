public class MyLinkedList{
    private Node head;
    private Node tail;
    public MyLinkedList(){
	head = null;
	tail = null;
    }
    
    public String toString(){
	Node temp = head;
	String s = "";
	while (temp != null){
	    s = s + temp.toString() + " ";
	    temp = temp.getNext();
	}
	return s;
    }


    public void add(String s){
	Node temp = new Node(s);
	//head = temp;
	temp.setNext(head);
	head = temp;
    }
       
    public void add(int i, String s){
	Node temp = head;
	for (int j = 0; j<i; j++){
	    temp = temp.getNext();
	    if (j == i-1){
		temp.setNext(new Node(s));
	    }
	}
    }
    public void addEnd(String s){
	Node temp = head;
	while (temp.getNext() != null){
	    temp = temp.getNext();
	}
	temp.setNext(new Node(s));
	temp = temp.getNext();
	temp.setNext(tail);	
    }
    
    public String get(int i){
	Node temp = head;
	for (int j = 0; j< i;j++){
	    temp = temp.getNext();
	    if (j+1==i){
		return temp.getData();
	    }
	}
	return temp.getData();
    }

    public String set(int i, String s){
	add(i, s);
	remove(i+1);
	return get(i);
    }

    public String remove(int i){
	Node temp = head;
	int a = 0;
	String s = "";
	while (temp != null){
	    if (a == i-1){
	        s = temp.getNext().getData();
		temp.setNext(temp.getNext().getNext());
	    }
	    a++;
	    temp = temp.getNext();
	}
	return s;
    }

    public int find (String s){
	Node temp = head;
	int count = 0;
	while (temp != null){
	    if (temp.getData() == s)
		return count;
	    count = count +1;
	    temp = temp.getNext();
	}
	return -1;
    }
    public int length(){
	Node temp = head;
	int count = 0;
	while (temp != null){
	    count = count + 1;
	    temp = temp.getNext();
	}
	return count;
    }

    public static void main(String[] args){
	MyLinkedList L = new MyLinkedList();
	L.add("Sully");
	L.add("Mike");
	L.add("");
	L.add("Mike");
	L.addEnd("Emma");
	L.remove(1);
	System.out.println(L.find("Sully"));
	System.out.println(L.length());
	System.out.println(L);

    }

    
}
