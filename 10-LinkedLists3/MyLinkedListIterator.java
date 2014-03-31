import java.util.*;

public class MyLinkedListIterator<E> implements Iterator {
    private Node a;

    public MyLinkedListIterator(Node n) {
        a = n;
    }
    public boolean hasNext() {
	return a.getNext()!=null;
    }
    public E next() {
	a = a.getNext();
	return (E) a.getData();
    }
    public void remove() {
    }
}