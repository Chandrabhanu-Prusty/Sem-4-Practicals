# Graph represented as adjacency list
graph = {
'1': ['2', '5'],
'2': ['1','3', '4','5'],
'3': ['2', '4', '6'],
'4': ['2', '3', '5', '6'],
'5': ['1', '2', '4', '6'],
'6': ['3', '4', '5'],
}

# Breadth First Search (BFS)
def bfs(graph, start, goal):
    queue = [(start, [start])]
    visited = set()
    
    while queue:
        node, path = queue.pop(0)
        if node == goal:
            return path
        
        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    queue.append((neighbor, path + [neighbor]))
    return None

# Depth First Search (DFS)
def dfs(graph, start, goal):
    stack = [(start, [start])]
    visited = set()
    
    while stack:
        node, path = stack.pop()
        if node == goal:
            return path
        
        if node not in visited:
            visited.add(node)
            for neighbor in reversed(graph[node]):
                if neighbor not in visited:
                    stack.append((neighbor, path + [neighbor]))
    return None

# Depth Limited Search (DLS)
def dls(graph, start, goal, limit):
    def recursive_dls(node, path, depth):
        if node == goal:
            return path
        if depth == 0:
            return None
        
        for neighbor in graph[node]:
            result = recursive_dls(neighbor, path + [neighbor], depth - 1)
            if result:
                return result
        return None
    
    return recursive_dls(start, [start], limit)

# Function to print required output format
def display_result(algo_name, path):
    print("\nAlgorithm:", algo_name)
    if path:
        print("Path Found")
        print("Path =", path)
    else:
        print("Goal Not Found")

# Main Execution
start_node = '1'
goal_node = '6'
depth_limit = 3

display_result("Breadth First Search (BFS)", bfs(graph, start_node, goal_node))
display_result("Depth First Search (DFS)", dfs(graph, start_node, goal_node))
display_result("Depth Limited Search (DLS)", dls(graph, start_node, goal_node, depth_limit))