//부분수열의 합
/*
[문제]
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
[입력]
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
[출력]
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
*/
//DFS 사용해야 함.
import java.util.Scanner;

public class Q1182
{
    static int N, S;
    static int nums[];
    static int count = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];

        for(int i = 0; i < N; i++)
        {
            nums[i] = sc.nextInt();
        }

        DFS(0, 0);

        if(S == 0)
        {
            count--;
        }

        System.out.println(count);

        sc.close();
    }

    static void DFS(int index, int sum)
    {
        if(index == N)
        {
            if(sum == S)
            {
                count++;
            }
            
            return;
        }

        DFS(index + 1, sum + nums[index]);
        DFS(index + 1, sum);
    }
}