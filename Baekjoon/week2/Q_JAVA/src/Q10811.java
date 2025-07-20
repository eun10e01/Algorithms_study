import java.util.Scanner;

public class Q10811
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int numbers[] = new int[N + 1];
		
		for(int k = 0; k < N + 1; k++)
		{
			numbers[k] = k;
		}
		
		for(int k = 1; k <= M; k++)
		{
			int i = scan.nextInt();
			int j = scan.nextInt();
			
			while(i < j)
			{
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				
				i++;
				j--;
			}
		}
		
		for(int k = 1; k <= N; k++)
		{
			System.out.print(numbers[k] + " ");
		}
		
		scan.close();
	}
}