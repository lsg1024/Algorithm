while True:
      
  n = int(input())

  if n == -1:
    break
    
  list = []
  for i in range(1, n):
    if n % i == 0:
      list.append(i)

  s_num = sum(list)
  print(list)
  print(s_num)

  if s_num == n:
     print(f"{n} = ", end="")
     print(" + ".join(map(str, list)))
  else:
    print("{} is NOT perfect.".format(n))
    