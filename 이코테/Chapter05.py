def factorial_recursive(n):
    if n <= 1:
        return 1
    return n * factorial_recursive(n-1)

# print(factorial_recursive(5))

# 인접 행렬 방식 예제
INF = 999999999

graph = [
    [0, 7, 5],
    [7, 0 ,INF],
    [5, INF, 0]
]

# print(graph)

# 인접 리스트 방식 예제
graph = [[] for _ in range(3)]

# 노드 0에 연결된 노드 정보 저장(노드, 거리)
graph[0].append((1,7))
graph[0].append((2,5))

# 노드 1에 연결된 노드 정보 저장
graph[1].append((0,7))

# 노드 2에 연결된 노드 정보 저장
graph[2].append((0,5))
print(graph)

# DFS 예제 - 142
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)
            
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6 , 8],
    [1, 7]
]

visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)
print("\n")

# BFS 예제
from collections import deque

# BFS 메서드 정의
def bfs(graph, start, visited):
    
    queue = deque([start])
    
    visited[start] = True
    
    while queue:
        
        v = queue.popleft()
        print(v, end=" ")
    
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]           

visited = [False] * 9

bfs(graph, 1, visited)   
print("\n")

