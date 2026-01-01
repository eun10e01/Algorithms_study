import java.util.Scanner;

public class Q10809
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String S = scan.next();
		
		for(int i = 'a'; i <= 'z'; i++)
		{
			System.out.print(S.indexOf((char)i) + " ");
		}
		
		scan.close();
	}
}