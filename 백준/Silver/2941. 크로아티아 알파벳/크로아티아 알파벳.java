import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int count = 0;
        int i = 0;

        while(i < str.length())
        {
            if(i + 2 < str.length() && str.charAt(i) == 'd' && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')
            {
                count++;
                i += 3;
            }
            else if(str.charAt(i) == 'c')
            {
                if(i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-'))
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else if(str.charAt(i) == 'd')
            {
                if(i + 1 < str.length() && str.charAt(i + 1) == '-')
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else if(str.charAt(i) == 'l')
            {
                if(i + 1 < str.length() && str.charAt(i + 1) == 'j')
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else if(str.charAt(i) == 'n')
            {
                if(i + 1 < str.length() && str.charAt(i + 1) == 'j')
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else if(str.charAt(i) == 's')
            {
                if(i + 1 < str.length() && str.charAt(i + 1) == '=')
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else if(str.charAt(i) == 'z')
            {
                if(i + 1 < str.length() && str.charAt(i + 1) == '=')
                {
                    count++;
                    i += 2;
                }
                else
                {
                    count++;
                    i++;
                }
            }
            else
            {
                count++;
                i++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}