import math

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F', 'G'],
    'D': 3, 'E': 5, 'F': 2, 'G': 9
}

def alpha_beta(node, depth, alpha, beta, is_maximizing):
    # Base case: if node is a leaf (integer) or depth reached
    if not isinstance(graph.get(node), list) or depth == 0:
        return graph[node], [node]

    if is_maximizing:
        best_val = -math.inf
        best_path = []
        for child in graph[node]:
            value, path = alpha_beta(child, depth - 1, alpha, beta, False)
            if value > best_val:
                best_val = value
                best_path = [node] + path
            
            alpha = max(alpha, best_val)
            if beta <= alpha:
                break  # Beta cut-off
        return best_val, best_path

    else:
        best_val = math.inf
        best_path = []
        for child in graph[node]:
            value, path = alpha_beta(child, depth - 1, alpha, beta, True)
            if value < best_val:
                best_val = value
                best_path = [node] + path
            
            beta = min(beta, best_val)
            if beta <= alpha:
                break  # Alpha cut-off
        return best_val, best_path

# Execution
val, path = alpha_beta('A', 2, -math.inf, math.inf, True)

print("Algorithm Name: Alpha-Beta Pruning")
print(f"Optimal Path / Moves: {' -> '.join(path)}")
print(f"Final Evaluated Value for MAX = {val}")