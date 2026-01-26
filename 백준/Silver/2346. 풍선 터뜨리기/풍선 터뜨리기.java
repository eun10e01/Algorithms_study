import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> balloons = new ArrayDeque<>();

        int N = sc.nextInt();
        int move[] = new int[N];

        for(int i = 0; i < N; i++)
        {
            move[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++)
        {
            balloons.add(i);
        }

        while(true)
        {
            int temp = balloons.poll();
            int m = move[temp - 1];

            System.out.print(temp + " ");

            if(balloons.isEmpty())
            {
                break;
            }

            if(m > 0)
            {
                m -= 1;

                for(int i = 0; i < m; i++)
                {
                    balloons.add(balloons.poll());
                }
            }
            else
            {
                for(int i = 0; i < Math.abs(m); i++)
                {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        sc.close();
    }
}