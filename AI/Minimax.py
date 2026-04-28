import math

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F', 'G'],
    'D': 3, 'E': 5, 'F': 2, 'G': 9
}

def minimax(node, depth, is_max):
    children = graph.get(node)

    if not isinstance(children, list) or depth == 0:
        return graph[node], [node]

    best_path = []

    if is_max:
        best = -math.inf
        for child in children:
            val, path = minimax(child, depth-1, False)
            if val > best:
                best = val
                best_path = [node] + path
        return best, best_path

    else:
        best = math.inf
        for child in children:
            val, path = minimax(child, depth-1, True)
            if val < best:
                best = val
                best_path = [node] + path
        return best, best_path

val, path = minimax('A', 2, True)
print("Path:", " -> ".join(path))
print("Value:", val)