def hanoi(n, s, a, d):
    if n == 1:
        print(f"Move 1 from {s} to {d}")
        return
    hanoi(n-1, s, d, a)
    print(f"Move {n} from {s} to {d}")
    hanoi(n-1, a, s, d)

hanoi(3, 'A', 'B', 'C')