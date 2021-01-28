import java.util.*;
import java.lang.Math;
class Node
{
	Node left,right;
	int data;
	Node(int item)
	{
		data=item;
		left=right=null;
	}
}
class Lca
{
	Node root;
	static int V=7;
	static int []nodes=new int[2*V-1];
	static int []depth=new int[2*V-1];
	static int []last11=new int[7];
	int [][]idxtbl;
	int fill;
	void visited(Node node,int l)
	{
		nodes[fill]=node.data;
		depth[fill]=l;
		last11[node.data]=fill;
		fill+=1;
	}
	void eulerTour(Node node,int l)
	{
		if(node==null)
			return;
		visited(node,l);
		if(node.left!=null)
		{
			eulerTour(node.left,l+1);
			visited(node,l);
		}
		if(node.right!=null)
		{
			eulerTour(node.right,l+1);
			visited(node,l);
		}
	}
		
	int[][] createsparsetable()
	{
		int p=(int)(Math.log(2*V-1)/Math.log(2));
		idxtbl=new int[p+1][2*V+1];
		int [][]lookup=new int[p+1][2*V-1];
		for(int i=0;i<2*V-1;i++)
		{
			lookup[0][i]=depth[i];
			idxtbl[0][i]=i;
		}
		for(int i=1;i<=p;i++)
		{
			for(int j=0;j+(1<<i)<=2*V-1;j++)
			{
				int left=lookup[i-1][j];
				int right=lookup[i-1][j+(1<<(i-1))];
				lookup[i][j]=Math.min(left,right);
				
				if(left <= right)
				idxtbl[i][j] = idxtbl[i-1][j];
				else
				idxtbl[i][j] = idxtbl[i -1][j + (1 << (i - 1))];
				//System.out.print(" "+lookup[i][j]);
			}
			//System.out.println();
		}
		return lookup;
	}
	int findlca(Node node,int u,int v)
	{
		fill=0;
		eulerTour(root,0);
		int [][]lookup=createsparsetable();
		int a=Math.min(last11[u],last11[v]);
		int b=Math.max(last11[u],last11[v]);
		int r=b-a+1;
		int p=(int)(Math.log(r)/Math.log(2));
		int res=(lookup[p][a]<lookup[p][b-(1<<p)+1])?idxtbl[p][a]:idxtbl[p][b-(1<<p)+1];
		//System.out.println(res);
		return nodes[res];
	}
		
		
	public static void main(String []args)
	{
		Lca l=new Lca();
		l.root=new Node(0);
		l.root.left=new Node(1);
		l.root.left.left=new Node(3);
		l.root.right=new Node(2);
		l.root.right.left=new Node(4);
		l.root.right.right=new Node(5);
		l.root.right.left.left=new Node(6);
		System.out.println(l.findlca(l.root,1,3));
		
			
	}
}
		