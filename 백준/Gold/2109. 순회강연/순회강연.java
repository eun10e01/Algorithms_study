import java.io.*;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> money = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        int offer[][] = new int[n][2];

        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            offer[i][0] = d;
            offer[i][1] = p;
        }

        Arrays.sort(offer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < n; i++)
        {
            money.add(offer[i][1]);

            if(money.size() > offer[i][0])
            {
                money.poll();
            }
        }

        int size = money.size();

        for(int i = 0; i < size; i++)
        {  
            sum += money.poll();
        }

        System.out.println(sum);

        br.close();
    }
}