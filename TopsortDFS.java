import java.io.*;
import java.util.Arrays;
import java.util.*;
class TopsortDFS
{
	public int []ordering;
	public static int V;
	public ArrayList<ArrayList<Integer>>adj;
	//public ArrayList<ArrayList<Integer>>adjT;
	TopsortDFS(int v)
	{
		V=v;
		adj=new ArrayList<ArrayList<Integer>>(V);
		//adjT=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
			//adjT.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
		//adjT.get(v).add(u);
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
	/*public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of nodes");
		TopsortDFS t=new TopsortDFS(Integer.parseInt(br.readLine()));
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
		for(int k=0;k<ans.length;k++)
			System.out.println(" "+ans[k]);
	}*/
}
		