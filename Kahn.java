import java.io.*;
import java.util.Arrays;
import java.util.*;
class Kahn
{
	private static int V;
	private	ArrayList<ArrayList<Integer>>adj;
	Kahn(int v)
	{
		V=v;
		adj=new ArrayList<ArrayList<Integer>>(v);
		for(int i=0;i<v;i++)
			adj.add(new ArrayList<Integer>());
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
	}
	int[] topsort()
	{
		int j,index;
		int []ordering=new int[V];
		int []indegree=new int[V];
		Arrays.fill(indegree,0);
		Arrays.fill(ordering,0);
		index=0;
		for(int i=0;i<V;i++)
		{
			Iterator<Integer> it=adj.get(i).iterator();
			while(it.hasNext())
			{
				j=it.next();
				indegree[j]+=1;
			}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<V;i++)
		{
			if(indegree[i]==0)
				q.add(i);
		}
		while(!q.isEmpty())
		{
			int a=q.poll();
			ordering[index++]=a;
			Iterator<Integer> it1=adj.get(a).iterator();
			while(it1.hasNext())
			{
				j=it1.next();
				indegree[j]-=1;
				if(indegree[j]==0)
					q.add(j);
			}
		}
		if(index!=V)
			System.out.println("The directed graph has cyclic nature");
		
		return ordering;
	}
			
	
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of edge you want to enter");
		Kahn t=new Kahn(Integer.parseInt(br.readLine()));
		for(int i=0;i<V;i++)
		{
			int a,b;
			System.out.println("FROM :");
			a=Integer.parseInt(br.readLine());
			System.out.println("TO :");
			b=Integer.parseInt(br.readLine());
			t.addEdge(a,b);
		}
		int []ans=t.topsort();
		for(int i=0;i<ans.length;i++)
			System.out.println(" "+ans[i]);
	}
}

		
		
		
		