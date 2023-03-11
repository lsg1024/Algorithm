n = int(input())

move_l = list(map(str, input().split()))

point = {
  'L' : (0, -1),
  'R' : (0, 1),
  'U' : (-1, 0),
  'D' : (1, 0)
}

start = [1, 1]
for i in move_l:
  p0 = start[0] + point[i][0]
  p1 = start[1] + point[i][1]
  if 1 <= p0 <= n and 1 <= p1 <= n:
    start = [p0, p1]

print(start[0], start[1])