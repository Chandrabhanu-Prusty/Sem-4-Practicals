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

def a_star(start, goal):
    open_list = []
    # Priority queue stores (f_score, node)
    heapq.heappush(open_list, (heuristic[start], start))
    g_cost = {start: 0}
    parent = {start: None}
    visited = set()

    while open_list:
        _, current = heapq.heappop(open_list)

        if current == goal:
            path = []
            while current:
                path.append(current)
                current = parent[current]
            return path[::-1] # Reverse path to get start-to-goal

        if current in visited:
            continue
        
        visited.add(current)

        for neighbor, cost in graph[current]:
            new_g = g_cost[current] + cost
            
            if neighbor not in g_cost or new_g < g_cost[neighbor]:
                g_cost[neighbor] = new_g
                f_score = new_g + heuristic[neighbor]
                heapq.heappush(open_list, (f_score, neighbor))
                parent[neighbor] = current

    return None

print("Path:", a_star('A', 'F'))