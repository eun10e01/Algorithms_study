import java.util.Scanner;

public class Q1009
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++)
		{
			int a = scan.nextInt();
			int b = scan.nextInt() % 4;
			
			int num = 1;
			
			if(b == 0)
			{
				for(int j = 0; j < 4; j++)
				{
					num *= a;
				}
			}
			else
			{
				for(int j = 0; j < b; j++)
				{
					num *= a;
				}
			}
			
			if(num % 10 == 0)
			{
				System.out.println(10);
			}
			else
			{
				System.out.println(num % 10);
			}
		}
		
		scan.close();
	}
}