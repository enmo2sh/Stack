package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * class of methods to implement stack
 *
 */
public class NodeStack implements IStack{
	 NodeStack.Node top;
		/**
		* Removes the element at the top of stack and returns that element.
		*
		* return top of stack element, or through exception if empty
		*/
	public Object pop() {
		int length=size();
		if (length==0)
			throw new ArithmeticException("the stack is empty");
		else {
		Object element=top.value;
		top=top.next;
		return element;
		}
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* return top of stack element, or through exception if empty
	*/
	public Object peek() {
		int length=size();
		if (length==0)
			throw new ArithmeticException("the stack is empty");
		else {
		Object element=top.value;
		return element;
		}
	}
	/**
	* Pushes an item onto the top of this stack.
	*
	* param object
	* to insert
	*/
	public void push(Object element) {
		NodeStack.Node current=new Node();
		current.value=element;
		current.next=top;
		top=current;
	}
	/**
	* Tests if this stack is empty
	*
	* return true if stack empty
	*/
	public boolean isEmpty() {
		if (top==null)
			return true;
		else
		return false;
	}
	/**
	* Returns the number of elements in the stack.
	*
	* return number of elements in the stack
	*/
	public int size() {

     NodeStack.Node current=top;
     int size=0;
     while(current!=null) {
    	 size++;
    	 current=current.next;
     }
     return size;
	}
	/**
	 * 
	 * class to create node
	 *
	 */
	public class Node {
		public Object value;
		public Node next;
	}

}
