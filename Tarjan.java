import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.lang.Math;
class Tarjan
{
	private static int pointer;
	private static int V;
	private static int []component;
	private static ArrayList<ArrayList<Integer>>adj;
	Tarjan(int n)
	{
		V=n;
		adj=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<Integer>());
		pointer=0;
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
	}
	void dfs(int x,int index[],int llv[],Boolean onstack[],Stack<Integer> s)
	{
		
		int j;
	
		index[x]=pointer;
		llv[x]=pointer;
		pointer+=1;
		onstack[x]=true;
		s.push(x);
		Iterator<Integer> it=adj.get(x).iterator();
		while(it.hasNext())
		{
			j=it.next();
			if(index[j]==-1)
			
				dfs(j,index,llv,onstack,s);
				//llv[x]=Math.min(llv[x],llv[j]);
			
			if(onstack[j])
				llv[x]=Math.min(llv[x],llv[j]);
		}
		int check=-1;
		if(index[x]==llv[x])
		{
			while(check!=x)
			{
				check=(int)s.pop();
				component[check]=x;
				System.out.print(" "+check);
				onstack[check]=false;
			}
			System.out.println();
		}
		
	}
	void perform()
	{
		int []index=new int[V];
		int []llv=new int[V];
		Boolean []onstack=new Boolean[V];
		Arrays.fill(index,-1);
		Arrays.fill(llv,-1);
		Arrays.fill(onstack,false);
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<V;i++)
		{
			if(index[i]==-1)
				dfs(i,index,llv,onstack,s);
		}
	}
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the no of nodes");
		Tarjan t=new Tarjan(Integer.parseInt(br.readLine()));
		System.out.println("Enter the number of edges");
		int e=Integer.parseInt(br.readLine());
		component=new int[V];
		for(int i=0;i<e;i++)
		{
			int a,b;
			System.out.println("FROM :");
			a=Integer.parseInt(br.readLine());
			System.out.println("TO :");
			b=Integer.parseInt(br.readLine());
			t.addEdge(a,b);
		}
		t.perform();
		for(int i=0;i<component.length;i++)
			System.out.print(" "+component[i]);
	}
}