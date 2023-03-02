n = int(input())

nums = list(map(int, input().split()))

count = 0

for i in range(n):
  
  if nums[i] <= 0:
    pass
  else:
    if nums[i] / 2 or nums[i] / 3 == 0:
      count += 1
    else:
      pass

print(count)
    
  