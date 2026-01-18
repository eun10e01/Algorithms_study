import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        int remainder = 0;
        int quotient = N;

        Stack<String> ans = new Stack<>();

        while(quotient > 0)
        {
            remainder = quotient % B;
            quotient = quotient / B;

            if(remainder >= 10)
            {
                char temp = (char)(remainder + 55L);
                ans.add(Character.toString(temp));
            }
            else
            {
                ans.add(Integer.toString(remainder));
            }
        }

        while(!ans.isEmpty())
        {
            System.out.print(ans.pop());
        }

        sc.close();
    }
}