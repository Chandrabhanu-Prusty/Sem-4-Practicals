import heapq

graph = {
    'A': [('B', 1), ('C', 3)],
    'B': [('D', 3), ('E', 1)],
    'C': [('F', 5)],
    'D': [], 'E': [], 'F': []
}

heuristic = {
    'A': 7, 'B': 6, 'C': 2, 'D': 1, 'E': 1, 'F': 0
}

def greedy_bfs(start, goal):
    pq = []
    heapq.heappush(pq, (heuristic[start], start))

    parent = {start: None}
    visited = set()

    while pq:
        _, curr = heapq.heappop(pq)

        if curr == goal:
            path = []
            while curr:
                path.append(curr)
                curr = parent[curr]
            return path[::-1]

        if curr in visited:
            continue
        visited.add(curr)

        for neigh, _ in graph[curr]:
            if neigh not in visited:
                heapq.heappush(pq, (heuristic[neigh], neigh))
                parent.setdefault(neigh, curr)

    return None

print("Path:", greedy_bfs('A', 'F'))