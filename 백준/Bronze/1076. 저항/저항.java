import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String color[] = new String[3];
        Long ans = 0L;

        for(int i = 0; i < 3; i++)
        {
            color[i] = sc.next();
        }

        //1
        switch(color[0])
        {
            case "black":
                ans = 0L;
                break;
            case "brown":
                ans = 10L * 1L;
                break;
            case "red":
                ans = 10L * 2L;
                break;
            case "orange":
                ans = 10L * 3L;
                break;
            case "yellow":
                ans = 10L * 4L;
                break;
            case "green":
                ans = 10L * 5L;
                break;
            case "blue":
                ans = 10L * 6L;
                break;
            case "violet":
                ans = 10L * 7L;
                break;
            case "grey":
                ans = 10L * 8L;
                break;
            case "white":
                ans = 10L * 9L;
                break;
        }

        //2
        switch(color[1])
        {
            case "black":
                ans += 0L;
                break;
            case "brown":
                ans += 1L;
                break;
            case "red":
                ans += 2L;
                break;
            case "orange":
                ans += 3L;
                break;
            case "yellow":
                ans += 4L;
                break;
            case "green":
                ans += 5L;
                break;
            case "blue":
                ans += 6L;
                break;
            case "violet":
                ans += 7L;
                break;
            case "grey":
                ans += 8L;
                break;
            case "white":
                ans += 9L;
                break;
        }

        //3
        switch(color[2])
        {
            case "black":
                ans *= 1L;
                break;
            case "brown":
                ans *= 10L;
                break;
            case "red":
                ans *= 100L;
                break;
            case "orange":
                ans *= 1000L;
                break;
            case "yellow":
                ans *= 10000L;
                break;
            case "green":
                ans *= 100000L;
                break;
            case "blue":
                ans *= 1000000L;
                break;
            case "violet":
                ans *= 10000000L;
                break;
            case "grey":
                ans *= 100000000L;
                break;
            case "white":
                ans *= 1000000000L;
                break;
        }

        System.out.println(ans);

        sc.close();
    }
}