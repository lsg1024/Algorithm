# 도저히 못하겠다 아직 내가 풀긴 어려움 ....
# 게임 크기
n, m = map(int, input().split())

# 현재 시작 위치
now_x, now_y, dt = map(int, input().split())
# 방문지역 필드 만들기
d = [[0] * m for _ in range(n)]

# 방문 위치 1 표시
d[now_x][now_y] = 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

print(d)

tile = []

for i in range(n):
  tile.append(list(map(int, input().split())))
  
tile[now_x][now_y] = 1

print(tile)
# while True:
#   # 반시계 방향으로 탐색 
#   for move in move_way:
#     print(move[0], move[1])

#   break
  
# print(n, m)
# print(now_x, now_y, dt)
# print(tile)