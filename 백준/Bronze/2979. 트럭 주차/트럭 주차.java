import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int truck[][] = new int[3][2];

        for(int i = 0; i < 3; i++)
        {
            st = new StringTokenizer(br.readLine());

            truck[i][0] = Integer.parseInt(st.nextToken());
            truck[i][1] = Integer.parseInt(st.nextToken());
        }
        
        LinkedList<String> parking = new LinkedList<>();

        int max_time = Math.max(truck[0][1], Math.max(truck[1][1], truck[2][1]));
        int money = 0;

        for(int i = 1; i <= max_time; i++)
        {
            if(truck[0][0] == i)
            {
                parking.add("1");
            }

            if(truck[1][0] == i)
            {
                parking.add("2");
            }

            if(truck[2][0] == i)
            {
                parking.add("3");
            }

            if(truck[0][1] == i)
            {
                parking.remove("1");
            }

            if(truck[1][1] == i)
            {
                parking.remove("2");
            }
            
            if(truck[2][1] == i)
            {
                parking.remove("3");
            }

            if(parking.size() == 1)
            {
                money += A;
            }
            else if(parking.size() == 2)
            {
                money += B * 2;
            }
            else if(parking.size() == 3)
            {
                money += C * 3;
            }
        }

        System.out.println(money);
    }
}