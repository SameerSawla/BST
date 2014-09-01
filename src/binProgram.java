
public class binProgram {

	private Node root;
	
	private class Node
	{
		private int value;
		private Node left,right;
		private int N;
		
		public Node(int value,int N)
		{
			this.value = value;
			this.N = N;
		}	
		
		
		public int getValue()
		{
			return value;
		}
		
	}
	
	private void put(int value)
	{
		root = put(root,value);
	}
	
	private Node put(Node x,int value)
	{
		if(x==null) { return new Node(value,1);}
		if(value<x.getValue()) { x.left = put(x.left,value);}
		else if(value>=x.getValue()){ x.right = put(x.right,value);}
		return x;
	}
	
	private Node min()
	{
		return min(root);
	}
	
	private Node min(Node x)
	{
		if(x==null) {return null;}
		while(x.left!=null)
		{
			x = x.left;
		}
		return x;
	}
	
	private Node max()
	{
		return max(root);
	}
	
	private Node max(Node x)
	{
		if(x==null)
		{
			return null;
		}
		while(x.right!=null)
		{
			x=x.right;
		}
		return x;
	}
	public static void main(String args[])
	{
		binProgram one = new binProgram();
		System.out.println("Hi");
		one.put(3);
		one.put(2);
		one.put(1);
		Node minNode = one.min();
		Node maxNode = one.max();
		System.out.println(minNode.getValue());
		System.out.println(maxNode.getValue());
		
	}
}
