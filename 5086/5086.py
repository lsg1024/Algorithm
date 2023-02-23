while True:
    
    a, b = map(int, input().split())
    if (a == 0 and b == 0):
        break
    list_a = []
    list_b = []
  
    for i in range(2, a+1):
        if (a % i == 0):
            list_a.append(i)
  
    for i in range(2, b+1):
        if (b % i == 0):
            list_b.append(i)

    list_s = [i for i in list_a if i in list_b]
  
    if not list_s:
        print("neither")
    
    else:
    
        if a > b:
            print("multiple")
        else:
            print("factor")
            
