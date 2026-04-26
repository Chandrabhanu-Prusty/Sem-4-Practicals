import heapq

graph = {
    'A': [('B', 1), ('C', 3)],
    'B': [('D', 3), ('E', 1)],
    'C': [('F', 5)],
    'D': [],
    'E': [],
    'F': []
}

heuristic = {
    'A': 7,
    'B': 6,
    'C': 2,
    'D': 1,
    'E': 1,
    'F': 0
}

def greedy_bfs(start, goal):
    open_list = []
    # Priority queue stores (heuristic_value, node_name)
    heapq.heappush(open_list, (heuristic[start], start))
    parent = {start: None}
    visited = set()

    while open_list:
        _, current = heapq.heappop(open_list)

        if current == goal:
            path = []
            while current:
                path.append(current)
                current = parent[current]
            return path[::-1] # Return reversed path

        if current in visited:
            continue
        
        visited.add(current)

        for neighbor, _ in graph[current]:
            if neighbor not in visited:
                heapq.heappush(open_list, (heuristic[neighbor], neighbor))
                if neighbor not in parent:
                    parent[neighbor] = current

    return None

print("Path:", greedy_bfs('A', 'F'))