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
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> D = new PriorityQueue<>(Collections.reverseOrder());

        int prev = 0;
        StringBuilder sb = new StringBuilder();

        int day = 0;

        for(int i = 0; i < N; i++)
        {
            D.add(Integer.parseInt(br.readLine()));
        }

        while(!D.isEmpty())
        {
            int work = D.poll();

            int satis_today = prev / 2 + work;

            sb.append(satis_today).append('\n');
            work -= M;
            day++;
            prev = satis_today;

            if(work > K)
            {  
                D.add(work);
            }
        }

        System.out.println(day);
        System.out.println(sb);

        br.close();
    }
}