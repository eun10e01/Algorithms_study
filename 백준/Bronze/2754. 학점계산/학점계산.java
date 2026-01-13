import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        
        double score = 0.0;
        
        switch(str.charAt(0)){
            case 'A':
                score = 4.0;
                break;
            case 'B':
                score = 3.0;
                break;
            case 'C':
                score = 2.0;
                break;
            case 'D':
                score = 1.0;
                break;
            case 'F':
                score = 0.0;
                break;
        }
        
        if(str.charAt(0) == 'F')
        {
            System.out.println(score);
        }
        else
        {
            if(str.charAt(1) == '+')
            {
                score += 0.3;
            }
            else if(str.charAt(1) == '-')
            {
                score -= 0.3;
            }
            
            System.out.println(score);
        }

        sc.close();
    }
}