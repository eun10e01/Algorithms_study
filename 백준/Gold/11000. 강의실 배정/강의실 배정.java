import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int lecture[][] = new int[N][2];

        PriorityQueue<Integer> classTime = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; i++)
        {
            if(!classTime.isEmpty() && classTime.peek() <= lecture[i][0])
            {
                classTime.poll();
            }

            classTime.add(lecture[i][1]);
        }

        System.out.println(classTime.size());
    }
}