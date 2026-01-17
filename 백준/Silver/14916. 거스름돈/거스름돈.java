import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int D[] = new int[100001];
		
		D[1] = -1;
		D[2] = 1;
		D[3] = -1;
		
		for(int i = 4; i < 100001; i++)
		{
			if(i % 5 == 0)
			{
				D[i] = i / 5;
			}
			else
			{
				int rem = i % 5;
				
				if(rem % 2 == 0)
				{
					D[i] = (i / 5) + (rem / 2);
				}
				else
				{
					D[i] = (i / 5 - 1) + ((rem + 5) / 2);
				}
			}
		}

		System.out.println(D[n]);
		
		sc.close();
	}
}