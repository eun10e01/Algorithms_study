import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        char f = 'a';

        for(int i = 2; i >= 0; i--)
        {
            if(A.charAt(i) == B.charAt(i))
            {
                continue;
            }
            else if(A.charAt(i) > B.charAt(i))
            {
                f = 'a';
                break;
            }
            else
            {
                f = 'b';
                break;
            }
        }

        if(f == 'a')
        {
            for(int i = 2; i >= 0; i--)
            {
                System.out.print(A.charAt(i));
            }
        }
        else
        {
            for(int i = 2; i >= 0; i--)
            {
                System.out.print(B.charAt(i));
            }
        }

        sc.close();
    }
}