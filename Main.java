import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Stack<Integer> stack = new Stack<>();		
		Scanner in = new Scanner(new FileReader("C:/Users/HUAWEI/Desktop/Task1.2021"));
		while(in.hasNext()) {
			if(in.hasNextInt()) {
				stack.push(in.nextInt());
			}
			else {
				char op = in.next().charAt(0);
				int x = stack.pop();
				int y = stack.pop();
				switch (op) {
				case '+':
					stack.push(x+y);
					break;
				case '-':
					stack.push(x-y);
					break;
				case '*':
					stack.push(x*y);
					break;
				case '/':
					stack.push(x/y);
					break;
				}
			}
		}
		System.out.println(stack.get(0));
	}

}
