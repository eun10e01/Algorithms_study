import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    static int king_w, king_n, stone_w, stone_n;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String words[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String nums[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        String king = sc.next();
        String stone = sc.next();
        int N = sc.nextInt();

        king_w = Arrays.asList(words).indexOf(Character.toString(king.charAt(0)));
        king_n = Arrays.asList(nums).indexOf(Character.toString((king.charAt(1))));

        stone_w = Arrays.asList(words).indexOf(Character.toString(stone.charAt(0)));
        stone_n = Arrays.asList(nums).indexOf(Character.toString((stone.charAt(1))));

        for(int i = 0; i < N; i++)
        {
            String temp = sc.next();
            
            switch(temp)
            {
                case "R":
                    R();
                    break;
                case "L":
                    L();
                    break;
                case "T":
                    T();
                    break;
                case "B":
                    B();
                    break;
                case "RT":
                    diagonal(1, 1);
                    break;
                case "RB":
                    diagonal(1, -1);
                    break;
                case "LT":
                    diagonal(-1, 1);
                    break;
                case "LB":
                    diagonal(-1, -1);
                    break;
            }
        }

        System.out.print(words[king_w] + nums[king_n] + "\n");
        System.out.print(words[stone_w] + nums[stone_n]);

        sc.close();
    }

    static void R()
    {
        if(king_w < 7)
        {
            if(king_w + 1 == stone_w && king_n == stone_n)
            {
                if(stone_w < 7)
                {
                    king_w++;
                    stone_w++;
                }
            }
            else
            {
                king_w++;
            }
        }
    }

    static void L()
    {
        if(king_w > 0)
        {
            if(king_w - 1 == stone_w && king_n == stone_n)
            {
                if(stone_w > 0)
                {
                    king_w--;
                    stone_w--;
                }
            }
            else
            {
                king_w--;
            }
        }
    }

    static void T()
    {
        if(king_n < 7)
        {
            if(king_n + 1 == stone_n && king_w == stone_w)
            {
                if(stone_n < 7)
                {
                    king_n++;
                    stone_n++;
                }
            }
            else
            {
                king_n++;
            }
        }
    }

    static void B()
    {
        if(king_n > 0)
        {
            if(king_n - 1 == stone_n && king_w == stone_w)
            {
                if(stone_n > 0)
                {
                    king_n--;
                    stone_n--;
                }
            }
            else
            {
                king_n--;
            }
        }
    }

    static void diagonal(int dw, int dn)
    {
        int kw = king_w + dw;
        int kn = king_n + dn;

        if(kw < 0 || kw > 7 || kn < 0 || kn > 7)
        {
            return;
        }

        if(kw == stone_w && kn == stone_n)
        {
            int sw = stone_w + dw;
            int sn = stone_n + dn;

            if(sw < 0 || sw > 7 || sn < 0 || sn > 7)
            {
                return;
            }

            stone_w = sw;
            stone_n = sn;
        }

        king_w = kw;
        king_n = kn;
    }
}