import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
            {
                System.out.print(Character.toString(str.charAt(i)).toLowerCase());
            }
            else
            {
                System.out.print(Character.toString(str.charAt(i)).toUpperCase());
            }
        }

        sc.close();
    }
}