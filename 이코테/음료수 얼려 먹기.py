# 처음 시도해본 dfs 문제 풀기보단 이해하는데 초점을 두고 풀었다
n, m = map(int, input().split())

# 그래프
graph = []
# 개수
count = 0

# 그래프 입력
for i in range(n):
  graph.append(list(map(int, input())))

# dfs 함수 
def dfs(x, y):
  
  # 리스트 범위에 넘어가면 종료
  if -1 >= x or -1 >= y or x >= n or y >= m:
    return False

  # 0값이 구멍난 곳
  if graph[x][y] == 0:
    # 0이 구멍 난 곳에 도착했기 때문에 1로 바꾸기 
    graph[x][y] = 1
    # 해당 위치에서 부터 다시 dfs 호출 순서대로 탐색해야되니
    dfs(x-1,y)
    dfs(x,y+1)
    dfs(x+1,y)
    dfs(x,y-1)
    return True
    
  return False

for i in range(n):
  for j in range(m):
    if dfs(i, j) == True:
      count += 1

print(count)
    
    
