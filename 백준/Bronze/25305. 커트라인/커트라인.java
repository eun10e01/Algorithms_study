import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> score = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            score.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < k - 1; i++)
        {
            score.poll();
        }

        System.out.println(score.poll());
    }
}