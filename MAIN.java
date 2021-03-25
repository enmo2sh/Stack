package eg.edu.alexu.csd.datastructure.stack;
import java.util.Scanner;
public class MAIN {
/**
 * user interface in part A
 * param args
 */
	public static void main(String[] args) {
		Scanner element=new Scanner(System.in);
		NodeStack.Node head=null;
		NodeStack check=new NodeStack();
		head=check.top;
		while (true) {
			System.out.println("1:Push");
			System.out.println("2:Pop");
			System.out.println("3:Peek");
			System.out.println("4:Get size");
			System.out.println("5:Check if empty");
			System.out.println("----------------------------------");
			int op=element.nextInt();
			if (op==1) {
				System.out.println("Please enter the object you want to push:");
				Object ip=element.next();
				check.push(ip);
			}
			else if (op==2) {
				Object ip;
				ip=check.pop();
				System.out.println("you popped:"+ip);
				System.out.println("------------------------------");
			}
			else if(op==3) {
				Object ip;
				ip=check.peek();
				System.out.println("the peek of the stack:"+ip);
				System.out.println("------------------------------");
			}
			else if(op==4) {
				int size=check.size();
				System.out.println("the size of the stack:"+size);
				System.out.println("-------------------------------");
			}
			else if (op==5) {
				boolean ip;
				ip=check.isEmpty();
				if (ip==true)
					System.out.println("the stack is empty");
				else
					System.out.println("the stack isnot empty");
				System.out.println("-------------------------------");
			}
			else 
				return;
		}
	}
}
