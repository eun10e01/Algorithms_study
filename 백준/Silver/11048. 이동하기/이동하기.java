import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int candy[][] = new int[N + 1][M + 1];
		
		int D[][] = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= M; j++)
			{
				candy[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= M; j++)
			{
				D[i][j] = candy[i][j] + Math.max(Math.max(D[i-1][j], D[i][j-1]), D[i-1][j-1]);
			}
		}
		
		System.out.println(D[N][M]);
		
		sc.close();
	}
}