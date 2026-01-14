import java.util.Scanner;

public class Main
{
    static int first[] = new int[26];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String name;
        boolean check = false;

        for(int i = 0; i < N; i++)
        {
            name = sc.next();

            char temp = name.charAt(0);

            first[temp - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            if(first[i] >= 5)
            {
                System.out.print((char)(i + 'a'));
                check = true;
            }
        }

        if(check == false)
        {
            System.out.println("PREDAJA");
        }

        sc.close();
    }
}