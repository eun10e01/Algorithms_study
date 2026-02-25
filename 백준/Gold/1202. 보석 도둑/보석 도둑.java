import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int MV[][] = new int[N][2];

        PriorityQueue<Integer> C = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            MV[i][0] = Integer.parseInt(st.nextToken());
            MV[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(MV, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < K; i++)
        {
            C.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> price = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        long ans = 0;

        while(!C.isEmpty())
        {
            int now_bag = C.poll();

            while(index < N && MV[index][0] <= now_bag)
            {
                price.add(MV[index][1]);
                index++;
            }

            if(!price.isEmpty())
            {
                ans += price.poll();
            }
        }

        System.out.println(ans);
    }
}