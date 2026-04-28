graph = {
    'A': [('B', 8), ('C', 6)],
    'B': [('D', 5), ('E', 7)],
    'C': [('F', 4), ('G', 3)],
    'D': [('H', 0)],
    'E': [], 'F': [], 'G': [], 'H': []
}

heuristic = {
    'A': 10, 'B': 8, 'C': 6,
    'D': 5, 'E': 7, 'F': 4,
    'G': 3, 'H': 0
}

def hill_climbing(start, goal):
    current = start
    path = [current]

    while current != goal:
        neighbors = graph[current]
        if not neighbors:
            return path

        next_node = min(neighbors, key=lambda x: heuristic[x[0]])[0]

        if heuristic[next_node] >= heuristic[current]:
            return path

        current = next_node
        path.append(current)

    return path

print("Path:", " -> ".join(hill_climbing('A', 'H')))