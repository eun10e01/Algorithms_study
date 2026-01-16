import java.io.*;
import java.util.StringTokenizer;

public class Main
{
	static int maxLen;
	static int B[] = new int[1000001];
	static int A[] = new int[1000001];
	static int D[] = new int[1000001];
	static int ans[] = new int[1000001];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int index;
		
		B[++maxLen] = A[1];
		D[1] = 1;
		
		for(int i = 2; i <= N; i++)
		{
			if(B[maxLen] < A[i])
			{
				B[++maxLen] = A[i];
				D[i] = maxLen;
			}
			else
			{
				index = binarysearch(1, maxLen, A[i]);
				B[index] = A[i];
				D[i] = index;
			}
		}
		
		System.out.println(maxLen);
		
		index = maxLen;
		
		int x = B[maxLen] + 1;
		
		for(int i = N; i >= 1; i--)
		{
			if(D[i] == index && A[i] < x)
			{
				ans[index] = A[i];
				x = A[i];
				index--;
			}
		}
		
		for(int i = 1; i <= maxLen; i++)
		{
			System.out.println(ans[i] + " ");
		}
	}
	
	static int binarysearch(int l, int r, int now)
	{
		int mid;
		
		while (l < r)
		{
			mid = (l + r) / 2;
			
			if(B[mid] < now)
			{
				l = mid + 1;
			}
			else
			{
				r = mid;
			}
		}
		
		return l;
	}
}