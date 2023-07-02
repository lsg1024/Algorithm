# n 개 카드 수 m 값 이하
n, m = map(int, input().split())

data = list(map(int, input().split()))

result = 0

# 브루트포트 전역 탐색 알고리즘
for i in range(n):
  # i 값보다 같거나 작으면 안되니깐 +1
  for j in range(i+1, n):
    # j 값보다 같거나 작으면 안되니깐 +1
    for k in range(j+1, n):
      sum = data[i] + data[j] + data[k]
      if (sum <= m):
        result = max(result, sum)

print(result)
