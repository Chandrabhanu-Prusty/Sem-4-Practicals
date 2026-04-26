def hanoi(n, source, auxiliary, destination):
    if n == 1:
        print(f"Move disk 1 from {source} → {destination}")
        return   
    # Step 1: Move n-1 disks from source to auxiliary
    hanoi(n - 1, source, destination, auxiliary)
    # Step 2: Move the nth disk from source to destination
    print(f"Move disk {n} from {source} → {destination}")
    # Step 3: Move n-1 disks from auxiliary to destination
    hanoi(n - 1, auxiliary, source, destination)
# Execution
n_disks = 3
print(f"Steps to solve Tower of Hanoi with {n_disks} disks:")
hanoi(n_disks, 'A', 'B', 'C')
