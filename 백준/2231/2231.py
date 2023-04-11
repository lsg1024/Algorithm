n = int(input())
# n을 찾는 것
result = 0
for i in range(1, n):
  # n 값을 쪼게고 합친 값
  num = sum((map(int, str(i))))
  num_s = i + num
  if num_s == n:
    result = i
    break
    
print(result)