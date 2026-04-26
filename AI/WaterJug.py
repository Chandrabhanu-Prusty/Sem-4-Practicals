def water_jug_bfs(jug1_cap, jug2_cap, target):
    # Queue stores (jug1, jug2, path_taken)
    queue = deque([(0, 0, [])])
    visited = set()
    print(f"Starting BFS for Target: {target}L")
    while queue:
        curr_j1, curr_j2, path = queue.popleft()        
        if (curr_j1, curr_j2) in visited:
            continue        
        visited.add((curr_j1, curr_j2))
        new_path = path + [(curr_j1, curr_j2)]        
        # Check Goal State
        if curr_j1 == target or curr_j2 == target:
            for state in new_path:
                print(state)
            print("Target Reached!")
            return True
        # Possible Transitions
        rules = [
            (jug1_cap, curr_j2), # Fill J1
            (curr_j1, jug2_cap), # Fill J2
            (0, curr_j2),        # Empty J1
            (curr_j1, 0),        # Empty J2
            # Pour J1 -> J2
            (curr_j1 - min(curr_j1, jug2_cap - curr_j2), curr_j2 + min(curr_j1, jug2_cap - curr_j2)),
            # Pour J2 -> J1
            (curr_j1 + min(curr_j2, jug1_cap - curr_j1), curr_j2 - min(curr_j2, jug1_cap - curr_j1))
        ]        
        for state in rules:
            if state not in visited:
                queue.append((state[0], state[1], new_path))          
    print("No solution found.")
    return False
# Execution
water_jug_bfs(4, 3, 2)
