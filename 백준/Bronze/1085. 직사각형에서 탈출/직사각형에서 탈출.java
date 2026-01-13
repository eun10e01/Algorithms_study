import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = Math.min(y, Math.min(x, Math.min(w-x, h-y)));

        System.out.println(min);

        sc.close();
    }
}