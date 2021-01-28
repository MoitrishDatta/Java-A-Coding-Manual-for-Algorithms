import java.io.*;
import java.util.Arrays;
class Dijkstra extends Bellman
{
	//final static int V=9;
	int res,location;
	/*public static void heapify(int arr[],int i)
	{
		int temp;
		int left=2*i+1;
		int right=2*i+2;
		if(left < arr.length())
			heapify(arr,left);
		if(right < arr.length())
			heapify(arr,right);
		if(arr[left]<arr[i] && left < arr.length())
		{
			if(res>arr[left])
			{
				res=arr[left];
				location=left;
			}	
			temp=arr[left];
			arr[left]=arr[i];
			arr[i]=temp;
		}
		if(arr[right]<arr[i] && right < arr.length())
		{
			if(res>arr[right])
			{
				res=arr[right];
				location=right;
			}	
			temp=arr[right];
			arr[right]=arr[i];
			arr[i]=temp;
		}
	}*/
			
	int minloc(int dist[],Boolean set[],int V)
	{
		int min=Integer.MAX_VALUE;
		int min_loc=-1;
		for(int i=0;i<V;i++)
		{
			if(!set[i] && dist[i]<=min)
			{
				min=dist[i];
				min_loc=i;
			}
		}
		return min_loc;
	}
		
	public int[] Evaluate(int graph[][],int V,int src)
	{
		int dist[]=new int[V];
		Arrays.fill(dist,Integer.MAX_VALUE);
		Boolean set[]=new Boolean[V];
		Arrays.fill(set,false);
		dist[src]=0;
		for(int c=0;c<V-1;c++)
		{
			int u=minloc(dist,set,V);
			set[u]=true;
			for(int i=0;i<V;i++)
			{
				if(!set[i] && graph[u][i]!=Integer.MAX_VALUE && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][i]<dist[i])
					dist[i]=dist[u]+graph[u][i];
			}
		}
		return dist;
	}
		
		
	/*public static void main(String []args)
	{
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
		Dijkstra dj=new Dijkstra();
		dj.Eval(graph,0);
	}*/
}
