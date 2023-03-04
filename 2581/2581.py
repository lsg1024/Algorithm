m = int(input())
n = int(input())

num_l = []

for num in range(m, n+1):
  result = True
  if num < 2:
    result = False
  else:
    for i in range(2, int(num**0.5)+1):
      if num % i == 0:
        result = False
        break
  if result:
    num_l.append(num)
  
if not num_l:
  print(-1)
else:
  print(sum(num_l))
  print(min(num_l))