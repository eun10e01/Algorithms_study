import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int B = sc.nextInt();

        double decimal = 0;

        for(int i = 0; i < N.length(); i++)
        {
            if(N.charAt(i) >= 'A' && N.charAt(i) <= 'Z')
            {
                decimal += ((N.charAt(i) - 55) * Math.pow(B, (N.length() - i - 1)));
            }
            else
            {
                decimal += (Integer.parseInt(Character.toString(N.charAt(i))) * Math.pow(B, (N.length() - i - 1)));
            }
        }

        System.out.println((new Double(decimal)).longValue());

        sc.close();
    }
}