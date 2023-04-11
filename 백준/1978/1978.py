n = int(input())

nums = list(map(int, input().split()))
count = 0

for num in nums:
  result = True
  if num < 2:
    result = False
    pass
  else:
    for i in range(2, int(num**0.5) + 1):
      if num % i == 0:
        result = False
        break
  if result == True:
    count += 1 
    
print(count)