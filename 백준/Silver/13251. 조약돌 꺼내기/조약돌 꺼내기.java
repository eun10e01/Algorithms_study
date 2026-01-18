import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int D[] = new int[51];
		double P[] = new double[51];
		
		int M = sc.nextInt();
		int T = 0;
		
		for(int i = 0; i < M; i++)
		{
			D[i] = sc.nextInt();
			T += D[i];
		}
		
		int K = sc.nextInt();
		double ans = 0;
		
		for(int i = 0; i < M; i++)
		{
			if(D[i] >= K)
			{
				P[i] = 1.0;
				
				for(int j = 0; j < K; j++)
				{
					P[i] *= (double)(D[i] - j) / (T - j);
				}
			}
			
			ans += P[i];
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}