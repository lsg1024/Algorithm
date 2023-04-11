n = int(input())

def enter(name):
  log.add(name[:5])

def leave(name):
  log.remove(name[:5])
  
# 회사 사람들 로그
log = set()

for _ in range(n):
  name, state = map(str, input().split())
  
  if state == "enter":
    enter(name)
  elif state == "leave":
    leave(name)

for name in sorted(log, reverse=True):
  print(name)