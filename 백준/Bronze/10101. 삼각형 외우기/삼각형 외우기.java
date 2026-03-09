import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        Map<Integer, Integer> angleCnt = new HashMap<>();

        for(int i = 0; i < 3; i++)
        {
            int angle = Integer.parseInt(br.readLine());

            if(angleCnt.containsKey(angle))
            {
                angleCnt.put(angle, angleCnt.get(angle) + 1);
            }
            else
            {
                angleCnt.put(angle, 1);
            }

            sum += angle;
        }

        if(sum == 180)
        {
            if(angleCnt.size() == 1)
            {
                System.out.println("Equilateral");
            }
            else if(angleCnt.size() == 2)
            {
                System.out.println("Isosceles");
            }
            else
            {
                System.out.println("Scalene");
            }
        }
        else
        {
            System.out.println("Error");
        }
    }
}