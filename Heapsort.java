import java.io.*;
class Heapsort
{
	public void heapify(int arr[],int n,int i)
	{
		int temp;
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[largest])
			largest=left;
		if(right<n && arr[right]>arr[largest])
			largest=right;
		if(largest!=i)
		{
			temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			heapify(arr,n,largest);
		}
	}
			
	public void sort(int arr[],int n)
	{
		int temp;
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,n,i);
		for(int i=n-1;i>0;i--)
		{
			temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			heapify(arr,i,0);
		}
		for(int i=0;i<n;i++)
			System.out.println(" "+arr[i]);
		
	}
			
	public static void main(String[] args)
	{
		int []arr=new int[]{15,12,17,10,6,5,7};
		Heapsort h=new Heapsort();
		h.sort(arr,arr.length);
	}
}
		