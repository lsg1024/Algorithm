q, p = map(int, input().split())
list = []
for i in range(1, q+1):
  if (q % i == 0):
    list.append(q//i)
    
list.sort()

try:
  print(list[p-1])
except:
  print(0)