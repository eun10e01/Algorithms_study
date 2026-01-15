import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int p[][] = new int[3][2];
		
		for(int i = 0; i < 3; i++)
		{
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		
		int result = (p[0][0] * p[1][1] + p[1][0] * p[2][1] + p[2][0] * p[0][1]) - (p[1][0] * p[0][1] + p[2][0] * p[1][1] + p[0][0] * p[2][1]);
		
		if(result > 0)
		{
			System.out.println(1);
		}
		else if(result < 0)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(0);
		}
		
		sc.close();
	}
}