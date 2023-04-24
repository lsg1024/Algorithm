import math

n_list = []

def mean(n_list):
  return print(math.trunc(sum(n_list)/5))

def median(n_list):
  n_list.sort()
  print(n_list[2])
    
  
for _ in range(5):
  n_list.append(int(input()))

mean(n_list)
median(n_list)