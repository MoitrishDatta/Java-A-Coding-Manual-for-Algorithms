import java.io.*;
import java.util.Arrays;
class Johnshon extends Dijkstra
{
	
	public int[][] addDummy(int arr[][],int n)
	{
		int [][]arr1=new int[n+1][n+1];
		for(int i=0;i<n+1;i++)
			arr1[0][i]=0;
		for(int i=1;i<n+1;i++)
			arr1[i][0]=Integer.MAX_VALUE;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				arr1[i][j]=arr[i-1][j-1];
			}
		}
		return arr1;
	}
	public static void main(String []args)
	{
		int v=5;
		int [][]asps=new int[v][v];
		int graph[][]=new int[][]{
									{0,-1,4,Integer.MAX_VALUE,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,0,3,1,2},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,1,5,0,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-3,0}};
		Johnshon j=new Johnshon();
		int [][]arr1=j.addDummy(graph,v);
		int []dist=j.Eval(arr1,v+1,0);
		for(int i=0;i<v;i++)
		{
			for(int k=0;k<v;k++)
			{
				if(graph[i][k]<Integer.MAX_VALUE)
					graph[i][k]+=dist[i+1]-dist[k+1];
				//System.out.print(" "+graph[i][k]);
			}
			//System.out.println();
		}
		for(int i=0;i<v;i++)
			asps[i]=j.Evaluate(graph,v,i);
		for(int i=0;i<v;i++)
		{
			for(int k=0;k<v;k++)
			{
				if(asps[i][k]<Integer.MAX_VALUE)
					asps[i][k]+=dist[k+1]-dist[i+1];
			}
		}
		for(int i=0;i<v;i++)
		{
			for(int k=0;k<v;k++)
			{
				System.out.print(" "+asps[i][k]);
			}
			System.out.println();
		}
			
	}
}