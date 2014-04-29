public class MyArrayStack {

	private int top;
	private int[] array;
	
	public MyArrayStack(int capacity){
		if(capacity < 0){
			throw new IllegalArgumentException(
                    "Please initiate with a positive number.");
			}
		array = new int[capacity];
		top = -1; 
	}
	
	public void push(int value) {
        if (top == array.length)
              System.out.println("Stack's underlying storage is overflow");
        top++;
        array[top] = value;
  }

  public int peek() {
        if (top == -1)
        	System.out.println("Stack is empty");
        return array[top];
  }

  public int pop() {
	  int curr = array[top];
        if (top == -1)
        	System.out.println("Stack is empty");
        top--;
        return curr;
  }

  public boolean isEmpty() {
        return (top == -1);
  }
  
  public String toString() {
		String s="";
		
		for (int tmp = top; tmp != -1; tmp--){
		    s = s + array[tmp]+", ";
		}
		return s;
  }
  
  public static void main(String[] args){
		MyArrayStack a = new MyArrayStack(3);
		a.push(1);
		a.push(2);
		a.push(3);
		System.out.println(a);
		while (!a.isEmpty()){
		    System.out.println(a.pop());
		}
		a.push(3);
		System.out.println(a.peek());
		a.push(4);
		System.out.println(a.peek());
  }
}
