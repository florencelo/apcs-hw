import java.util.*;

public class RPN {
	
	private static MyArrayStack a = new MyArrayStack();
	
	public static boolean nextIsOperator(String next) {
	    return (next.equals("+") || next.equals("-") || next.equals("*") || next
	        .equals("/"));
	  }
	
	public static double calc(String input){
		String next;
	    Stack<Double> stack = new Stack<Double>();
	    Scanner scan = new Scanner(input);

	    while (scan.hasNext()) {
	      next = scan.next();

	      if (nextIsOperator(next)) {
	        if (stack.size() > 1) {
	          if (next.equals("+")) {
	            stack.push((Double) stack.pop() + (Double) stack.pop());
	          } else if (next.equals("-")) {
	            stack.push(-(Double) stack.pop() + (Double) stack.pop());
	          } else if (next.equals("*")) {
	            stack.push((Double) stack.pop() * (Double) stack.pop());
	          } else if (next.equals("/")) {
	            double first = stack.pop();
	            double second = stack.pop();

	            if (first == 0) {
	              System.out.println("The RPN equation attempted to divide by zero.");
	            } else {
	              stack.push(second / first);
	            }
	          }
	        } else {
	          System.out.println("A mathematical operator occured before there were enough numerical values for it to evaluate.");
	        }
	      } else {
	        try {
	          stack.push(Double.parseDouble(next));
	        } catch (NumberFormatException c) {
	          System.out.println("The string is not a valid RPN equation.");
	        }
	      }
	    }

	    if (stack.size() > 1) {
	      System.out.println("Numbers exceed mathematical operators.");
	    }

	    return (Double) stack.pop();
	  }
	
	public static void main (String [] args){
		System.out.println(calc("2 3 *"));
		System.out.println(calc("2 3 * 8 +"));
		System.out.println(calc("2 3 * 10 + 3 -"));
		System.out.println(calc("2 3 * 7 + 9 + 0"));
		System.out.println(calc("2 3 * 9 +"));
	}
}
