import java.io.*;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        int children[] = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            gifts.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            children[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean check = true;

        for(int i = 0; i < M; i++)
        {
            int g = gifts.poll();

            if(children[i] <= g)
            {
                gifts.add(g - children[i]);
            }
            else
            {
                check = false;
                break;
            }
        }

        if(check)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }

        br.close();
    }
}