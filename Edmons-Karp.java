import java.io.*;
import java.util.*;
import java.lang.*;
class Edmon
{
	private static int V=6;
	boolean bfs(int rgraph[][],int s,int t,int parent[])
	{
		int temp; 
		boolean []visited=new boolean[V];
		Arrays.fill(visited,false);
		parent[s]=-1;
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(s);
		visited[s]=true;
		while(q.size()!=0)
		{
			temp=q.poll();
			for(int i=0;i<V;i++)
			{
				if(visited[i]==false && rgraph[temp][i]>0)
				{
					q.add(i);
					visited[i]=true;
					parent[i]=temp;
				}
			}
		}
		return (visited[t]==true);
	}
			
	public int findFordFulkerson(int arr[][],int s,int t)
	{
		System.out.println("Entereed ford");
		int max_flow=0;
		int a,b;
		int [][]rgraph=new int[V][V];
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				rgraph[i][j]=arr[i][j];
				System.out.print(" "+rgraph[i][j]);
			}
			System.out.println();
		}
		int []parent=new int[V];
		while(bfs(rgraph,s,t,parent))
		{
			System.out.println("Entered bfs");
			for(int i=0;i<parent.length;i++)
				System.out.print(" "+parent[i]);
			int min_path=Integer.MAX_VALUE;
			for(a=t;a!=s;a=parent[a])
			{
				b=parent[a];
				System.out.println(rgraph[b][a]);
				min_path=Math.min(min_path,rgraph[b][a]);
				//System.out.print(rgraph[b][a]);
			}
			for(a=t;a!=s;a=parent[a])
			{
				b=parent[a];
				rgraph[b][a]-=min_path;
				rgraph[a][b]+=min_path;
			}
			max_flow+=min_path;
			
			//System.out.println(min_path);
		}
		return max_flow;
	}
			
			

		
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int src,tar;
		int [][]arr=new int[][]{{0, 16, 13, 0, 0, 0}, 
                                     {0, 0, 10, 12, 0, 0}, 
                                     {0, 4, 0, 0, 14, 0}, 
                                     {0, 0, 9, 0, 0, 20}, 
                                     {0, 0, 0, 7, 0, 4}, 
                                     {0, 0, 0, 0, 0, 0} 
                                   }; 
		System.out.print(arr[0][1]);
		Edmon e=new Edmon();
		//System.out.println("Enter the source and the target vertex");
		//src=Integer.parseInt(br.readLine());
		//tar=Integer.parseInt(br.readLine());
		
		System.out.println("The max flow from the vertex to the  vertex is "+e.findFordFulkerson(arr,0,5));
	}
}