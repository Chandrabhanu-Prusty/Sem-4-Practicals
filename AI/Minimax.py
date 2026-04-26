import math

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F', 'G'],
    'D': 3, 'E': 5, 'F': 2, 'G': 9
}

def minimax(node, depth, is_maximizing):
    # Base case: if node is a leaf (integer) or depth reached
    if not isinstance(graph.get(node), list) or depth == 0:
        return graph[node], [node]

    if is_maximizing:
        best_val = -math.inf
        best_path = []
        for child in graph[node]:
            value, path = minimax(child, depth - 1, False)
            if value > best_val:
                best_val = value
                best_path = [node] + path
        return best_val, best_path

    else:
        best_val = math.inf
        best_path = []
        for child in graph[node]:
            value, path = minimax(child, depth - 1, True)
            if value < best_val:
                best_val = value
                best_path = [node] + path
        return best_val, best_path

# Execution
val, path = minimax('A', 2, True)

print("Algorithm Name: Minimax")
print(f"Optimal Path / Moves: {' -> '.join(path)}")
print(f"Final Evaluated Value for MAX = {val}")