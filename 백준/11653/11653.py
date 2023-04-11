n = int(input())
a = 2

while n > 1:
  if n % a == 0:
    n //= a
    print(a)
  else:
    a += 1