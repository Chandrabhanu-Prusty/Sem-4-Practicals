from collections import deque

graph = {
    '1': ['2', '5'],
    '2': ['1','3', '4','5'],
    '3': ['2', '4', '6'],
    '4': ['2', '3', '5', '6'],
    '5': ['1', '2', '4', '6'],
    '6': ['3', '4', '5'],
}

def bfs(graph, start, goal):
    queue = deque([(start, [start])])
    visited = set()
    
    while queue:
        node, path = queue.popleft()
        if node == goal:
            return path
        
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    queue.append((neighbor, path + [neighbor]))
    return None

def dfs(graph, start, goal):
    stack = [(start, [start])]
    visited = set()
    
    while stack:
        node, path = stack.pop()
        if node == goal:
            return path
        
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    stack.append((neighbor, path + [neighbor]))
    return None

def dls(graph, start, goal, limit):
    def recursive(node, path, depth, visited):
        if node == goal:
            return path
        if depth == 0:
            return None
        
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                res = recursive(neighbor, path + [neighbor], depth - 1, visited)
                if res:
                    return res
        return None
    
    return recursive(start, [start], limit, set())

def display(algo, path):
    print("\nAlgorithm:", algo)
    print("Path Found:", path if path else "No Path")

print(display("BFS", bfs(graph, '1', '6')))
print(display("DFS", dfs(graph, '1', '6')))
print(display("DLS", dls(graph, '1', '6', 3)))