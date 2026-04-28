class FamilyTree:
    def __init__(self):
        self.family = {
            'John': {'gender': 'M', 'children': ['Mary', 'James']},
            'Sara': {'gender': 'F', 'children': ['Mary', 'James']},
            'Mary': {'gender': 'F', 'children': ['Lily']},
            'James': {'gender': 'M', 'children': []},
            'Lily': {'gender': 'F', 'children': []}
        }

    def is_father(self, x, y):
        data = self.family.get(x, {})
        return data.get('gender') == 'M' and y in data.get('children', [])

    def are_siblings(self, x, y):
        if x == y: return False
        return any(x in p['children'] and y in p['children'] for p in self.family.values())

ft = FamilyTree()
print(ft.is_father('John', 'Mary'))
print(ft.are_siblings('Mary', 'James'))