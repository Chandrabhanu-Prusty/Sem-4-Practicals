# Example code : "As per the law, it is a crime for an American to sell weapons to hostile nations. Country A, an enemy of America, has some missiles, and all the missiles were sold to it by Robert, who is an American citizen. prove robert is criminal"

# Facts
facts = {
    "American(Robert)": True,
    "Enemy(CountryA, America)": True,
    "Missile(M1)": True,
    "Owns(CountryA, M1)": True,
    "Sells(Robert, M1, CountryA)": True
}
# Rule 1: Missile -> Weapon
def is_weapon(x):
    return facts.get(f"Missile({x})", False)
# Rule 2: Criminal Rule
def is_criminal(x):
    return (
        facts.get(f"American({x})", False) and
        is_weapon("M1") and
        facts.get(f"Sells({x}, M1, CountryA)", False) and
        facts.get("Enemy(CountryA, America)", False)
    )
# Query
print("Is Robert a Criminal?", is_criminal("Robert"))

#-------------------Problem 1--------------------------------------------------

#If a patient has fever and cough, then they may have flu. John has fever and cough. Prove that John has flu.

facts_1 = {
    "Fever(John)": True,
    "Cough(John)": True
}
def has_flu(person):
    # Rule: Fever(x) AND Cough(x) -> Flu(x)
    return facts_1.get(f"Fever({person})", False) and facts_1.get(f"Cough({person})", False)
print("Problem 1: Does John have flu?", has_flu("John"))


#-----------------------Problem 2--------------------------------------------------

#A student is eligible for placement if they have completed a degree and have skills.Alice has completed her degree and has programming skills.Prove Alice is eligible for placement.

facts_2 = {
    "CompletedDegree(Alice)": True,
    "HasSkills(Alice)": True
}
def is_eligible(student):
    # Rule: CompletedDegree(x) AND HasSkills(x) -> Eligible(x)
    return facts_2.get(f"CompletedDegree({student})", False) and facts_2.get(f"HasSkills({student})", False)
print("Problem 2: Is Alice eligible for placement?", is_eligible("Alice"))


#-----------------------Problem 3--------------------------------------------------

#If a person has a good credit score and stable income, then the loan is approved.Ravi has a good credit score and stable income.Prove Ravi gets loan approval.

facts_3 = {
    "GoodCredit(Ravi)": True,
    "StableIncome(Ravi)": True
}
def loan_approved(person):
    # Rule: GoodCredit(x) AND StableIncome(x) -> Approved(x)
    return facts_3.get(f"GoodCredit({person})", False) and facts_3.get(f"StableIncome({person})", False)
print("Problem 3: Is Ravi's loan approved?", loan_approved("Ravi"))

