//별 찍기 - 7
/*
[문제]
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
[입력]
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
[출력]
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
*/
import java.util.Scanner;

public class Q2444
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++)
        {
            for(int j = N - i; j > 0; j--)
            {
                System.out.print(" ");
            }

            for(int j = 1; j <= (2 * i) - 1; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }

        for(int i = 1; i <= N - 1; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }


            for(int j = (2 * (N - i)) - 1; j > 0; j--)
            {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}