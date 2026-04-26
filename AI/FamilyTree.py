class FamilyTree:
    def __init__(self):
        # Format: 'Name': {'gender': 'M/F', 'children': [list]}
        self.family = {
            'John': {'gender': 'M', 'children': ['Mary', 'James']},
            'Sara': {'gender': 'F', 'children': ['Mary', 'James']},
            'Mary': {'gender': 'F', 'children': ['Lily']},
            'James': {'gender': 'M', 'children': []},
            'Lily': {'gender': 'F', 'children': []}
        }
    def is_father(self, x, y):
        return self.family.get(x, {}).get('gender') == 'M' and y in self.family.get(x, {}).get('children', [])
    def is_mother(self, x, y):
        return self.family.get(x, {}).get('gender') == 'F' and y in self.family.get(x, {}).get('children', [])
    def are_siblings(self, x, y):
        if x == y: return False
        for parent, data in self.family.items():
            if x in data['children'] and y in data['children']:
                return True
        return False
# Execution
ft = FamilyTree()
print(f"Is John the father of Mary? {ft.is_father('John', 'Mary')}")
print(f"Are Mary and James siblings? {ft.are_siblings('Mary', 'James')}")
