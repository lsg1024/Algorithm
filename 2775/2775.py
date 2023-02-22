t = int(input()) # 테스트 케이스 수 입력받기

for _ in range(t):
    k = int(input()) # 층 수 입력받기
    n = int(input()) # 호실 수 입력받기

    # 각 층과 호실마다 거주민 수를 저장하는 2차원 리스트 초기화
    arr = [[0] * (n+1) for _ in range(k+1)]

    # 0층 거주민 수 초기화
    for i in range(n+1):
        arr[0][i] = i
        print(arr)
    # 각 층의 거주민 수 구하기
    for i in range(1, k+1):
        for j in range(1, n+1):
            arr[i][j] = arr[i-1][j] + arr[i][j-1]
            
    print(arr)

    print(arr[k][n]) # 결과 출력
