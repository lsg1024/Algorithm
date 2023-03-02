q, p = map(int, input().split())

cnt = 0
for i in range(1, q+1):
    if q % i == 0:
        # i 값이 증가 할때마다 cnt에 1씩 증가시켜 더한다
        cnt += 1
        # 더한 값을 p와 비교해서 같다면 그 값을 출력한다.
        # 값들은 나머지 0인 것들만 걸러져 들어왔다는걸 생각하기
        # 그렇다면 굳이 리스트를 만들어 넣을 필요가 없다
        if cnt == p:
            print(i)
            break
        
else:
    print(0)