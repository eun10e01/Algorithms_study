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

        ArrayDeque<Integer>[] order = new ArrayDeque[200001];
        
        int count[] = new int[N];

        for(int i = 1; i <= 200000; i++)
        {
            order[i] = new ArrayDeque<>();
        }

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++)
            {
                int type = Integer.parseInt(st.nextToken());
                order[type].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            int now = Integer.parseInt(st.nextToken());

            if(!order[now].isEmpty())
            {
                int customer = order[now].poll();
                count[customer]++;
            }
        }

        for(int i = 0; i < N; i++)
        {
            System.out.print(count[i] + " ");
        }

        br.close();
    }
}