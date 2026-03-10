import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        Deque<Integer> basket = new ArrayDeque<>();

        for(int i = 1; i <= M; i++)
        {
            basket.addLast(i);
        }

        int move = 0;

        for(int i = 0; i < J; i++)
        {
            int apple = Integer.parseInt(br.readLine());

            if(!basket.contains(apple))
            {
                if(basket.peekLast() < apple)
                {
                    int temp = basket.peekLast();

                    while(!basket.contains(apple))
                    {
                        temp++;
                        basket.addLast(temp);
                        basket.pollFirst();
                        move++;
                    }
                }
                else if(basket.peekFirst() > apple)
                {
                    int temp = basket.peekFirst();

                    while(!basket.contains(apple))
                    {
                        temp--;
                        basket.addFirst(temp);
                        basket.pollLast();
                        move++;
                    }
                }
            }
        }

        System.out.println(move);
    }
}