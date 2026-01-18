import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger D[][] = new BigInteger[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++)
		{
			D[i][0] = BigInteger.ONE;
			D[i][i] = BigInteger.ONE;
		}
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j < i; j++)
			{
				if(D[i][j] == null)
				{
					D[i][j] = BigInteger.ZERO;
				}
				D[i][j] = D[i - 1][j].add(D[i - 1][j - 1]);
			}
		}
		
		System.out.println(D[n][m]);
		
		sc.close();
	}
}