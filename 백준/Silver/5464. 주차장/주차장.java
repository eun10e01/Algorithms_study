import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Queue;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int price[] = new int[N];
        int cars[] = new int[M];

        int money = 0;

        for(int i = 0; i < N; i++)
        {
            price[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < M; i++)
        {
            cars[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> park = new PriorityQueue<>();
        Map<Integer, Integer> full = new HashMap<>();
        Queue<Integer> waiting = new LinkedList<>();

        for(int i = 1; i <= N; i++)
        {
            park.add(i);
        }

        for(int i = 0; i < M*2; i++)
        {
            int index = Integer.parseInt(br.readLine());

            if(park.isEmpty() && index > 0)
            {
                waiting.add(index);
            }
            else
            {
                if(waiting.isEmpty())
                {
                    if(index > 0)
                    {
                        money += (cars[index - 1] * price[park.peek() - 1]);
                        full.put(index, park.poll());
                    }
                    else
                    {
                        park.add(full.get(Math.abs(index)));
                        full.remove(Math.abs(index));
                    }
                }
                else
                {
                    if(index < 0)
                    {
                        park.add(full.get(Math.abs(index)));
                        full.remove(Math.abs(index));

                        index = waiting.poll();

                        money += (cars[index - 1] * price[park.peek() - 1]);
                        full.put(index, park.poll());
                    }
                    else
                    {
                        waiting.add(index);

                        index = waiting.poll();

                        money += (cars[index - 1] * price[park.peek() - 1]);
                        full.put(index, park.poll());
                    }
                }
            }
        }

        System.out.println(money);

        br.close();
    }
}