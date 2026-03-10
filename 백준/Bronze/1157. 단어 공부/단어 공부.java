import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String s = new String();
		int count[] = new int[26];
		
		s = scan.next();
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++)
		{
			count[(int)s.charAt(i) - 'a']++;
		}
		
		int max = 0;
		int answer = 0;
		boolean cheak = true;
		
		for(int i = 0; i < count.length; i++)
		{
			if(count[i] > max)
			{
				max = count[i];
				answer = i;
				cheak = true;
			}
			else if(count[i] == max && max != 0)
			{
				cheak = false;
			}
		}
		
		if(cheak)
		{
			System.out.println((char)(answer + 'A'));
		}
		else
		{
			System.out.println("?");
		}
		
		scan.close();
	}
}