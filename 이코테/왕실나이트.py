input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0]) - int(ord('a')) + 1)
# a = 97 ~ h = 104

# 이동 범위
status = [(-2, -1), (-2, 1), (-1, -2), (1, -2), (2, -1), (2, 1), (-1, 2), (1, 2)]

# 범위는 8 * 8 이므로 1 ~ 8 사이 값만 가능하다
# 입력 값들을 바꿔서 status 값에 있는 데이터를 넣었을 떄 0 미만 8 초과일 경우 아님
result = 0
for i in status:
  n = row + i[0]
  m = column + i[1]
  if (n >= 1 and n <= 8 and m >=1 and m <=8):
    result += 1

print(result)