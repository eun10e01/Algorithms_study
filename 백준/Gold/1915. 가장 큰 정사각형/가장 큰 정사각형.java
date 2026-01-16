import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		long D[][] = new long[1001][1001];
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long max = 0;
		
		for(int i = 0; i < n; i++)
		{
			String line = sc.next();
			
			for(int j = 0; j < m; j++)
			{
				D[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
				
				if(D[i][j] == 1 && j > 0 && i > 0)
				{
					D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + D[i][j];
				}
				
				if(max <= D[i][j])
				{
					max = D[i][j];
				}
			}
		}
		
		System.out.println(max * max);
		
		sc.close();
	}
}