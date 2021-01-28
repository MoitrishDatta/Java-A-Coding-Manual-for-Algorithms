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
class Binary
{
	Node root;
	static int [][]dp;
	static int log;
	static int []level;	
	static void dfs(Node node,int p)
	{
		dp[node.data][0]=p;
		for(int i=1;i<=log;i++)
			dp[node.data][i]=dp[dp[node.data][i-1]][i-1];
			
		if(node.left!=null)
		{
			level[node.left.data]=level[node.data]+1;
			dfs(node.left,node.data);
		}
		if(node.right!=null)
		{
			level[node.right.data]=level[node.data]+1;
			dfs(node.right,node.data);
		}
	}
	static int findlca(int a,int b)
	{
		int ra,rb,p,res;
		ra=a;
		rb=b;
		if(level[ra]<level[rb])
		{
			res=level[rb]-level[ra];
			p=(int)(Math.log(res)/Math.log(2));
			for(int i=p;i>=0;i--)
			{
				if(level[rb]-Math.pow(2,i)>=level[ra])
					rb=dp[rb][i];
			}
		}
		if(level[rb]<level[ra])
		{
			res=level[ra]-level[rb];
			p=(int)(Math.log(res)/(Math.log(2)));
			for(int i=p;i>=0;i--)
			{
				if(level[ra]-Math.pow(2,i)>=level[rb])
					ra=dp[ra][i];
			}
		}
		if(ra==rb)
			return ra;
		res=level[ra];
		p=(int)(Math.log(res)/Math.log(2));
		for(int i=p;i>=0;i--)
		{
			if(dp[ra][i]!=dp[rb][i])
			{
				ra=dp[ra][i];
				rb=dp[rb][i];
			}
		}
		return dp[ra][0];
	}
			
	public static void main(String []args)
	{
		int n=7;
		log=(int)Math.ceil(Math.log(n)/Math.log(2));
		dp=new int[n+1][log+1];
		level=new int[n+1];
		for(int i=0;i<n+1;i++)
			Arrays.fill(dp[i],-1);
		
		Binary l=new Binary();
		l.root=new Node(1);
		l.root.left=new Node(2);
		l.root.left.left=new Node(4);
		l.root.right=new Node(3);
		l.root.right.left=new Node(5);
		l.root.right.right=new Node(6);
		l.root.right.left.left=new Node(7);
		dfs(l.root,1);
		for(int i=0;i<level.length;i++)
			System.out.print(" "+level[i]);
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<log+1;j++)
			{
				System.out.print(" "+dp[i][j]);
			}
			System.out.println();
		}
		System.out.println(" "+findlca(4,4));
	}
}