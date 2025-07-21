import java.util.Scanner;

public class Q1717
{
	static int set[];
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		set = new int[n + 1];
		
		for(int i = 0; i <= n; i++)
		{
			set[i] = i;
		}
		
		for(int i = 0; i < m; i++)
		{
			int num = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			if(num == 0)
			{
				union(a, b);
			}
			else
			{
				if(check(a, b))
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
		
		scan.close();
	}
	
	static void union(int a, int b)
	{
		a = find(a);
		b = find(b);
		
		set[b] = a;
	}
	
	static int find(int n)
	{
		if(n == set[n])
		{
			return n;
		}
		else
		{
			return set[n] = find(set[n]);
		}
	}
	
	static boolean check(int a, int b)
	{
		a = find(a);
		b = find(b);
		
		if(a == b)
		{
			return true;
		}
		
		return false;
	}
}