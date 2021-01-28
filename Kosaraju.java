import java.io.*;
//import java.util.Arrays;
import java.util.*;
class Kosaraju 
{
	private static int []ordering;
	private static int V;
	private static ArrayList<ArrayList<Integer>>adj;
	private static ArrayList<ArrayList<Integer>>adjT;
	Kosaraju(int n)
	{
		V=n;
		adj=new ArrayList<ArrayList<Integer>>(V);
		adjT=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++)
		{
			adjT.add(new ArrayList<Integer>());
			adj.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
	}
	int DFS(int i,int at,Boolean set[])
	{
		int j;
		set[at]=true;
		Iterator<Integer> it=adj.get(at).iterator();
		while(it.hasNext())
		{
			j=it.next();
			if(!set[j])
				i=DFS(i,j,set);
		}
		ordering[i]=at;
		return i-1;
	}
	
	int[] topsort()
	{
		Boolean []set;
		int i;
		set=new Boolean[V];
		ordering=new int[V];
		Arrays.fill(set,false);
		Arrays.fill(ordering,0);
		i=V-1;
		
		for(int at=0;at<V;at++)
		{
			if(set[at]==false)
				i=DFS(i,at,set);
		}
		return ordering;
	}
	void DFSutil(int x,Boolean v[])
	{
		int j;
		System.out.print(" "+x);
		v[x]=true;
		Iterator<Integer> it=adjT.get(x).iterator();
		while(it.hasNext())
		{
			j=it.next();
			if(!v[j])
				DFSutil(j,v);
		}
	}
			
	
		
	void getTranspose()
	{
		
		for(int i=0;i<V;i++)
		{
			Iterator<Integer> it=adj.get(i).iterator();
			while(it.hasNext())
				adjT.get(it.next()).add(i);
		}
		
	}
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of nodes");
		Kosaraju t=new Kosaraju(Integer.parseInt(br.readLine()));
		System.out.println("Enter the number of edges");
		int e=Integer.parseInt(br.readLine());
		
		for(int i=0;i<e;i++)
		{
			int a,b;
			System.out.println("FROM :");
			a=Integer.parseInt(br.readLine());
			System.out.println("TO :");
			b=Integer.parseInt(br.readLine());
			t.addEdge(a,b);
		}
		int []ans=t.topsort();
		t.getTranspose();
		Boolean []visited=new Boolean[V];
		Arrays.fill(visited,false);
		for(int i=0;i<V;i++)
		{
			if(visited[ans[i]]==false)
			{
				t.DFSutil(ans[i],visited);
				System.out.println();
			}
		}
	}
}
