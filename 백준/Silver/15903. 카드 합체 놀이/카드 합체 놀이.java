import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            cards.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++)
        {
            long A = cards.poll();
            long B = cards.poll();

            cards.add(A + B);
            cards.add(A + B);
        }

        long ans = 0;

        while(!cards.isEmpty())
        {
            ans += cards.poll();
        }

        System.out.println(ans);

        br.close();
    }
}