import java.io.*;
import java.util.*;
import java.util.Arrays;
class Bellman
{
	//final static int v=6;
	public int[] Eval(int arr[][],int n,int src)
	{
		int []dist=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		//Boolean []set=new Boolean[v];
		//Arrays.fill(set,false);
		dist[src]=0;
		for(int i=1;i<=n-1;i++)
		{
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					if(dist[j]+arr[j][k]<dist[k])
						dist[k]=dist[j]+arr[j][k];
				}
			}
		}
		return dist;
	}
	/*public static void main(String []args)
	{
		int arr[][]=new int[][]{{0,0,0,0,0,0},
									{Integer.MAX_VALUE,0,-1,4,Integer.MAX_VALUE,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,0,3,1,2},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,1,5,0,Integer.MAX_VALUE},
									{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-3,0}};
		Bellman b=new Bellman();
		b.Eval(arr,0);
	}*/
}