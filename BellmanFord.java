import java.io.*;
import java.util.*;
import java.util.Arrays;
class Edge
{
	int fr;
	int to;
	double wt;
	public Edge(int f,int t,double w)
	{
		
		fr=f;
		to=t;
		wt=w;
	}
}
public class BellmanFord
{
	
	//no of vertices and no of edges
	
	static double min(double a,double b)
	{
		double m=(a<b)?a:b;
		return m;
	}	
	public static void main(String[] args)throws IOException
	{
		int v,e;
		ArrayList <Edge> G;
		int src;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the source vertex");
		src=Integer.parseInt(br.readLine());
		G=new ArrayList<Edge>();
		System.out.println("No of vertices");
		v=Integer.parseInt(br.readLine());
		System.out.println("No of edges");
		e=Integer.parseInt(br.readLine());
		for(int i=0;i<e;i++)
		{
			int from,to;
			double wt;
			System.out.println("Enter the source vertex for edge: "+i);
			from=Integer.parseInt(br.readLine());
			System.out.println("Enter the target vertex for edge: "+i);
			to=Integer.parseInt(br.readLine());
			System.out.println("Enter the weight for edge: "+i);
			wt=Double.parseDouble(br.readLine());
			Edge ed=new Edge(from,to,wt);
			G.add(ed);
		}
		double []dist=new double[v];
		Arrays.fill(dist,99999);
		dist[src]=0;
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<e;j++)
			{
				dist[G.get(j).to]=min(dist[G.get(j).to],dist[G.get(j).fr]+G.get(j).wt);
			}
		}
		for(int i=0;i<v;i++)
			System.out.println(dist[i]);
	}
}
		
	
	
			
			