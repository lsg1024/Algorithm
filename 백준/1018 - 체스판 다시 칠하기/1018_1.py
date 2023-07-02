# 솔직히 다른 실버 4문제보다 어려운거 같음 구현 방법은 바로 떠오르는데 실제 알고리즘 구현하는게 너무 오래걸림
# 처음에 한창 구현하다 8 * 8 조건을 순간 까먹어서 계속 틀렸음
# 해당 문제만 해결하면 케이스별로 값 구해서 최소값 구하기만 하면됨


# 조건 1 체스판 형태로 색을 칠해야된다 -> 그중에 최소값을 구하는 것
# 조건 2 체스판은 8 * 8 형태로 아무곳에서 출력이 가능하다

# 선택한 진행 방식 하나씩 점검해서 최소 값을 구하는 방식으로 진행
# 0, 0 일때 값과 마지막 모서리 값은 같아야된다
# 하단으로 탐색할때 이전에 시작했던 값과 옆에 값은 반대여야한다.
# 첫번째가 흰색이라고 가정하고 탐색하면 0,0은 흰색 0, 1은 검정색


def case_count(graph):
  count = float('inf')
  for i in range(len(graph)- 7):
    for j in range(len(graph[0])-7):
      repaint = 0
      for x in range(i, i+8):
        for y in range(j, j+8):
          if (x-i+y-j) % 2 == 0:
            if graph[x][y] != 'W':
              repaint += 1
          else:
            if graph[x][y] != 'B':
              repaint += 1

      count = min(count, repaint, 64-repaint)

  return count

n, m = map(int, input().split())

graph = []

for _ in range(n):
  graph.append(str(input()))

min_count = case_count(graph)

print(min_count)