n = int(input())

n_list = []

for i in range(n):
  n_list.append(int(input()))

n_list.sort()

print(*n_list, sep="\n")