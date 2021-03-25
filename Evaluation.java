package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @class to convert from infix to postfix and evaluate expression
 *
 */
public class Evaluation implements IExpressionEvaluator {
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	public String infixToPostfix(String expression) {
		String Postfix="";
		char parts[]=expression.toCharArray();
		NodeStack Stack=new NodeStack();
		NodeStack Post=new NodeStack();
		for (int i=0;i<parts.length;i++) {
			if (Character.isDigit(parts[i])) {
				int z=Character.getNumericValue(parts[i]);
				while ((i<parts.length-1)&&(Character.isDigit(parts[i+1]))) {
					z=z*10+Character.getNumericValue(parts[i+1]);
					i++;
				}
				Post.push(z);
			}	
			else
			{
				if ((parts[i]=='-')&&(Character.isDigit(parts[i+1]))&&(i==0)){
						String s="-"+parts[i+1];
						Post.push(s);
						i=i+1;
					}
				else if ((parts[i]=='-')&&(Character.isDigit(parts[i+1]))&&(!(Character.isDigit(parts[i-1]))&&(parts[i-1]!=')')))  {
						String s="-"+parts[i+1];
						Post.push(s);
						i=i+1;
					}	
				 if ((parts[i]=='+')||(parts[i]=='-')){
					int counter=1;
					while((Stack.size()>0)&&(counter==1)) {
						 Object temp=Stack.peek();
					if (((char)temp=='*')||((char)temp=='/')||((char)temp=='+')||((char)temp=='-')) {
						Object element=Stack.pop();
						Post.push(element);
						}
					else 
						counter=0;
					}
					Stack.push(parts[i]);
				}
				else if ((parts[i]=='*')||(parts[i]=='/')) {
					int counter=1;
					while((Stack.size()>0)&&(counter==1)) {
						Object temp=Stack.peek(); 
						 if (((char)temp=='*')||((char)temp=='/')) {
							Object element=Stack.pop();
							Post.push(element);
						 }
						 else 
							 counter=0;
						}
						Stack.push(parts[i]);
					}
				else if(parts[i]=='(') 
					Stack.push(parts[i]);
				else if (parts[i]==')') {
					Object temp2=Stack.pop();
					while ((char)temp2!='(') {
							Post.push(temp2);
							temp2=Stack.pop();
					}
				}
			}
		}
		while (!Stack.isEmpty()) {
			Object temp=Stack.pop();
			Post.push(temp);
		}
		 
		while (!Post.isEmpty()) {
			Object temp=Post.pop();
			Postfix=temp+" "+Postfix;
		}
		return Postfix;
	}
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	public int evaluate(String expression) {
		String[] parts=expression.split(" ");
		NodeStack result=new NodeStack();
		for (int i=0;i<parts.length;i++) {
			if (parts[i].equals(Character.toString('+'))) {
				float temp1=(float)result.pop();
				float temp2=(float)result.pop();
				float op=temp1+temp2;
				result.push(op);
			}
			else if (parts[i].equals(Character.toString('-'))) {
				float temp1=(float)result.pop();
				float temp2=(float)result.pop();
				float op=temp2-temp1;
				result.push(op);
			}
			else if (parts[i].equals(Character.toString('*'))) {
				float temp1=(float)result.pop();
				float temp2=(float)result.pop();
				float op=temp1*temp2;
				result.push(op);
			}
			else if (parts[i].equals(Character.toString('/'))) {
				float temp1=(float)result.pop();
				float temp2=(float)result.pop();
				float op;
				if(temp2==0.0)
					throw new ArithmeticException("/ by zero");
				else 
				 op=temp2/temp1;
				result.push(op);
			}
			else 
				result.push(Float.parseFloat(parts[i]));
		}
		float op=(float)result.pop();
		int output=(int)op;
		return output;
	}

}
