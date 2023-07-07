import sys

sys.setrecursionlimit(10000)

def gf_move(x, y):

  if x <= -1 or y <= -1 or x >= n or y >= m:
    return False
    
  if graph[x][y] == 1:
    graph[x][y] = 0
    gf_move(x-1, y)
    gf_move(x+1, y)
    gf_move(x, y-1)
    gf_move(x, y+1)

    return True

  return False
  
t = int(input())

for _ in range(t):
  count = 0
  graph = []
  m, n, k = map(int, input().split())
  for _ in range(n):
    row = []
    for _ in range(m):
      row.append(0)
    graph.append(row)
  
  for _ in range(k):
    x, y = map(int, input().split())
    graph[y][x] = 1 

  for i in range(n):
    for j in range(m):
      if gf_move(i,j) == True:
        count += 1

  print(count)