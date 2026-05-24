using namespace std;

int solution(int storey) {
    int answer = 0;

    while (storey > 0)
    {
        int n = storey % 10; //일의 자리의 수
        storey /= 10;        //자리 수 오른쪽으로 1칸씩 이동

        //(일의 자리 수) < 5 
        if (n < 5)
        {
            answer += n; //n만큼 마법의 돌 소모 (-1)
        }
        //(일의 자리 수) > 5
        else if (n > 5)
        {
            ++storey; //올림 처리 (ex) 48 > 50)
            answer += 10 - n; //10 - n만큼 마법의 돌 소모 (-1)
        }
        //(일의 자리 수) == 5
        else
        {
            int temp = storey % 10;

            if (temp >= 5) //다음 자리 수가 5이상이면
            {
                ++storey; //올림 처리
            }

            answer += n; //n만큼 마법의 돌 소모 (-1)
        }

    }

    return answer;
}