
public class BST {
	private Node root;
	private class Node
	{
		Node left;
		Node right;
		int value;
		
		public Node(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return value;
		}
		
	}
	
	public void insert(int value)
	{
		root = insert(root,value);
	}
	
	public Node insert(Node x,int value)
	{
		if(x==null){return new Node(value);}
		if(value<x.getValue()){x.left = insert(x.left,value);}
		else if(value>=x.getValue()){x.right = insert(x.right,value);}
		return x;
	}
	
	public Node min()
	{
		return min(root);
	}
	
	public Node min(Node x)
	{
		if(x==null){return null;}
		while(x.left!=null)
		{
			x= x.left;
		}
		return x;
	}
	
	public Node max()
	{
		return max(root);	
	}
	
	public Node max(Node x)
	{
		if(x==null){return null;}
		while(x.right!=null)
		{
		 x= x.right;	
		}
		return x;
		
	}
	
	public BST()
	{
		root = null;
	}
	
	public void inOrder()
	{
		inOrder(root);
	}
	
	public void inOrder(Node x)
	{
	 	if(x==null)
	 	{
	 		System.out.println("None to display");
	 	}
	 	else
	 	{
	 		if(x.left!=null) { inOrder(x.left);}
	 		System.out.println(x.getValue());
	 		if(x.right!=null){ inOrder(x.right);}
	 	}
	 	
	}
	
	public void preOrder()
	{
		preOrder(root);
	}	
	
	public void preOrder(Node x)
	{
		if(x==null) {System.out.println("None to display");}
		else
		{
			System.out.println(x.getValue());
			if(x.left!=null){ preOrder(x.left); }
			if(x.right!=null){ preOrder(x.right); }
		}
	}
	
	public void postOrder()
	{
		postOrder(root);
	}
	
	public void postOrder(Node x)
	{
		if(x==null){ System.out.println("None to print");}
		else
		{
			if(x.left!=null){postOrder(x.left);}
			if(x.right!=null){postOrder(x.right);}
			System.out.println(x.getValue());
		}
	}
	
	public int height()
	{
		return height(root);
	}
	
	public int height(Node x)
	{
		int height = 0 ; 
		if(x==null){return 0;}
		int left_height=0;
		int right_height=0;
		if(x.left!=null)
		{
			left_height = height(x.left);
		}
		if(x.right!=null)
		{
			right_height = height(x.right);
		}
		if(left_height>right_height)
		{
			return left_height+1;
		}
		else
		{
			 return right_height+1;
		}
				
	}
	
	public Node deleteMin(Node x)
	{
		if(x==null){return null;}
		if(x.left==null){return x.right;}
		x.left = deleteMin(x.left);
		return x;		
	}
	
	
	public void delete(int value)
	{
		root = delete(root,value);
	}
	
	public Node delete(Node x,int value)
	{
		if(x==null){return null;}
		if(value<x.getValue()){x.left = delete(x.left,value);}
		else if(value>x.getValue()){x.right = delete(x.right,value);}
		else
		{
			if(x.left==null){ return x.right;}
			if(x.right==null){ return x.left; }
				Node temp = x;
				x = min(temp.right);
				x.right = deleteMin(temp.right);
				x.left = temp.left;
			
		}
		return x;
		
		
	}
	public static void main(String args[])
	{
		try
		{
		BST init = new BST();
		init.insert(5);
		System.out.println("Entering 5");
		init.insert(4);
		System.out.println("Entering 4");
		init.insert(6);
		System.out.println("Entering 6");
		init.insert(7);
		System.out.println("Entering 7");
		init.insert(8);
		System.out.println("Entering 8");
		init.insert(9);
		System.out.println("Entering 9");
		init.insert(10);
		System.out.println("Entering 10");
		
		Node minNode = init.min();
		Node maxNode = init.max();
		System.out.println("\n\\/ MINVALUE ");
		System.out.println(minNode.getValue());
		System.out.println("\n\\/ MAXVALUE ");
		System.out.println(maxNode.getValue());
		System.out.println("\n\\/ INORDER ");
		init.inOrder();
		System.out.println("\n\\/ PREORDER" );
		init.preOrder();
		System.out.println("\n\\/ POSTORDER" );
		init.postOrder();
		System.out.println("\n\\/ HEIGHT" );
		System.out.println(init.height());
		
		
		System.out.println("\nDeleting 4");
		init.delete(10);
		
		minNode = init.min();
		maxNode = init.max();
		System.out.println("\n\\/ MINVALUE ");
		System.out.println(minNode.getValue());
		System.out.println("\n\\/ MAXVALUE ");
		System.out.println(maxNode.getValue());
		System.out.println("\n\\/ INORDER ");
		init.inOrder();
		System.out.println("\n\\/ PREORDER" );
		init.preOrder();
		System.out.println("\n\\/ POSTORDER" );
		init.postOrder();
		System.out.println("\n\\/ HEIGHT" );
		System.out.println(init.height());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
