public class MyArrayStack {

	private int top;
	private String[] array;
	private int capacity;
	
	public MyArrayStack(){
		capacity = 10;
		array = new String[capacity];
		top = -1; 
	}
	
	public void push(String value) {
		String[] tmp = new String[capacity + 1];
		top++;
        if (top < array.length){
            array[top] = value;
        }else{
        	capacity ++;
        	for(int i = 0; i < top; i++){
        		tmp[i] = array[i];
        	}
            tmp[top] = value;
            array = tmp;
        }
  }

  public String peek() {
        if (top == -1)
        	System.out.println("Stack is empty");
        return array[top];
  }

  public String pop() {
	  String curr = array[top];
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
		return s.substring(0,s.length()-2);
  }
  
  public static void main(String[] args){
		MyArrayStack a = new MyArrayStack();
		a.push("one");
		a.push("two");
		a.push("three");
		a.push("four");
		a.push("five");
		a.push("six");
		a.push("seven");
		a.push("eight");
		a.push("nine");
		a.push("ten");
		a.push("eleven");
		System.out.println(a);
		while (!a.isEmpty()){
		    System.out.println(a.pop());
		}
		a.push("three");
		System.out.println(a.peek());
		a.push("four");
		System.out.println(a.peek());
  }
}
