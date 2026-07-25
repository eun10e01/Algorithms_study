# [Silver Ⅴ] 카드돌리기 - 1050

[문제 링크](https://jungol.co.kr/problem/1050)

### 성능 요약

메모리: 1.3 MB, 시간: 4 ms

### 분류

문자열, 구현

### 제출 일자

2026년 7월 25일 22:49:03

### 문제 설명

<p>Bridge 같은 카드 게임은 52 장의 카드를 4 명의 사람에게 차례로 돌린다. 각 사람은 13 장의 카드를 받는다.
받은 네명의 사람의 카드를 소트하는 프로그램을 작성하시오.

카드무늬는 ♣(C) < ♦(D) < ♠(S) < ♥(H) 순이고, 각 무늬 당 번호는 2 < 3 < 4 < 5 < 6 < 7 < 8 < 9 < T < J < Q < K < A 순이다.

게이머는 동(North), 서(West), 남(South), 북(North)으로 자리를 차지하며 dealer 는 시계 방향으로 카드를 한 장씩 돌린다.
만약 dealer 가 북쪽사람이면 제일 첫 카드는 동쪽에 앉은 사람에게 돌아간다.</p>

<img width="237" height="213" alt="image" src="https://github.com/user-attachments/assets/567a81b2-b9c4-4e3e-ba26-53a3fe8ad73e" />

### 입력 

<p>입력의 첫 문자는 dealer를 하는 게이머의 위치를 다음의 두 줄은 차례로 돌아갈 카드들을 뜻한다.</p>

### 출력 

<p>네 라인을 아래 출력의 예와 같이 정렬하여 출력한다.
S: C3 C5 C7 CT CJ D9 DT DJ S3 SK H2 H9 HT
W: C2 C4 CK D4 D5 D6 DQ DA S4 S8 ST SJ H8
N: C6 C8 C9 CA D8 S9 SA H4 H5 H6 H7 HJ HA
E: CQ D2 D3 D7 DK S2 S5 S6 S7 SQ H3 HQ HK</p>
