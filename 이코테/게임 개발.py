n, m = map(int, input().split())
now_x, now_y, dt = map(int, input().split())

tile = []

for i in range(n):
  tile.append(list(map(int, input().split())))

# 북 동 남 서 -> 이동 방양 키
move_way = [(0, 1), (1, 0), (0, -1), (-1, 0)]

while True:
  # 반시계 방향으로 탐색 
  for move in move_way:
    print(move[0], move[1])

  break
  
# print(n, m)
# print(now_x, now_y, dt)
# print(tile)