//저항
/*
[문제]
전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다. 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다. 저항의 값은 다음 표를 이용해서 구한다.
색	값	곱
black	0	1
brown	1	10
red	    2	100
orange	3	1,000
yellow	4	10,000
green	5	100,000
blue	6	1,000,000
violet	7	10,000,000
grey	8	100,000,000
white	9	1,000,000,000
예를 들어, 저항의 색이 yellow, violet, red였다면 저항의 값은 4,700이 된다.
[입력]
첫째 줄에 첫 번째 색, 둘째 줄에 두 번째 색, 셋째 줄에 세 번째 색이 주어진다. 위의 표에 있는 색만 입력으로 주어진다.
[출력]
입력으로 주어진 저항의 저항값을 계산하여 첫째 줄에 출력한다.
*/
import java.util.Scanner;

public class Q1076
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